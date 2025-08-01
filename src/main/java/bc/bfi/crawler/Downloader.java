package bc.bfi.crawler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.brotli.dec.BrotliInputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

class Downloader {

    private final static String SCRAPENINJA_API_KEY = "602cc2a1femsh9bacd616bc8c076p1b5c9fjsn050eedb6ce7b";
    private static final Logger LOGGER = Logger.getLogger(Downloader.class.getName());

    private final Map<String, String> headers = new HashMap<String, String>() {
        {
            put("Host", "www.google.com");
            put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0");
            put("Accept", "*/*");
            put("Accept-Language", "en-US,en;q=0.5");
            put("Accept-Encoding", "gzip, deflate, br");
            put("Referer", "https://www.google.com/");
            put("Connection", "keep-alive");
            put("Content-Length", "0");
            put("TE", "Trailers");
        }
    };

    private String cookies = "";
    private boolean scrapeNinjaUsed = false;

    boolean wasScrapeNinjaUsed() {
        return scrapeNinjaUsed;
    }

    String loadBaseUrl(final String url) {
        String page = "";
        scrapeNinjaUsed = false;

        String baseUrl = Utils.extractBaseUrl(url);

        try {
            page = loadWithDirectConnection(baseUrl);
        } catch (IOException ex) {
            logDownloadError(baseUrl, ex);
            if (baseUrl.startsWith("https://") && isSslException(ex)) {
                String httpUrl = baseUrl.replaceFirst("^https://", "http://");
                try {
                    page = loadWithDirectConnection(httpUrl);
                } catch (IOException ex2) {
                    logDownloadError(httpUrl, ex2);
                }
            }
        }

        if (!page.isEmpty() && isClientChallenge(page)) {
            System.out.println("Client Challenge detected. Try to download " + baseUrl + " with ScrapeNinja.");
            scrapeNinjaUsed = true;
            try {
                page = loadWithScrapeNinja(baseUrl);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Cannot download " + baseUrl + " with ScrapeNinja.", ex);
            }
        }

        if (page.isEmpty()) {
            System.out.println("Direct download failed. Try to download " + baseUrl + " with ScrapeNinja.");
            scrapeNinjaUsed = true;
            try {
                page = loadWithScrapeNinja(baseUrl);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Cannot download " + baseUrl + " with ScrapeNinja.", ex);
            }
        }
        
        if(page.isEmpty()){
            System.out.println("ScrapeNinja download failed.");
        }

        return page;
    }

    String load(final String url) {
        String page = "";
        scrapeNinjaUsed = false;

        try {
            page = loadWithDirectConnection(url);
        } catch (IOException ex) {
            logDownloadError(url, ex);
            if (url.startsWith("https://") && isSslException(ex)) {
                String httpUrl = url.replaceFirst("^https://", "http://");
                try {
                    page = loadWithDirectConnection(httpUrl);
                } catch (IOException ex2) {
                    logDownloadError(httpUrl, ex2);
                }
            }
        }

        if (!page.isEmpty() && isClientChallenge(page)) {
            System.out.println("Client Challenge detected. Try to download " + url + " with ScrapeNinja.");
            scrapeNinjaUsed = true;
            try {
                page = loadWithScrapeNinja(url);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Cannot download " + url + " with ScrapeNinja.", ex);
            }
        }

        if (page.isEmpty()) {
            System.out.println("Direct download failed. Try to download " + url + " with ScrapeNinja.");
            scrapeNinjaUsed = true;
            try {
                page = loadWithScrapeNinja(url);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Cannot download " + url + " with ScrapeNinja.", ex);
            }
        }
        
        if(page.isEmpty()){
            System.out.println("ScrapeNinja download failed.");
        }

        return page;
    }

    private String loadWithScrapeNinja(final String url) throws IOException {
        String apiUrl = "https://scrapeninja.p.rapidapi.com/scrape?url=" + URLEncoder.encode(url, "UTF-8");

        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-RapidAPI-Host", "scrapeninja.p.rapidapi.com");
        conn.setRequestProperty("X-RapidAPI-Key", SCRAPENINJA_API_KEY);

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("ScrapeNinja request failed with HTTP code: " + responseCode);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            return extractBodyFromScrapeNinjaResponse(response.toString());
        }
    }

    private String extractBodyFromScrapeNinjaResponse(String json) {
        try (JsonReader reader = Json.createReader(new StringReader(json))) {
            JsonObject obj = reader.readObject();
            if (obj.containsKey("body")) {
                return obj.getString("body");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Failed to parse ScrapeNinja response", ex);
        }
        return json;
    }

    private String loadWithDirectConnection(final String url) throws IOException {
        URL theUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) theUrl.openConnection();

        connection.setInstanceFollowRedirects(true);
        connection.setRequestMethod("GET");

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        if (cookies != null && !cookies.isEmpty()) {
            connection.setRequestProperty("Cookie", cookies);
        }

        connection = redirect(connection, headers);

        byte[] data;
        if ("gzip".equals(connection.getContentEncoding())) {
            data = readStream(new GZIPInputStream(connection.getInputStream()));
        } else if ("br".equals(connection.getContentEncoding())) {
            data = readStream(new BrotliInputStream(connection.getInputStream()));
        } else {
            data = readStream(connection.getInputStream());
        }

        cookies = connection.getHeaderField("Set-Cookie");

        return new String(data, StandardCharsets.UTF_8);
    }

    /**
     * HttpURLConnection by design won't automatically redirect from HTTP to
     * HTTPS (or vice versa).
     *
     * This method fix this situation.
     */
    private HttpURLConnection redirect(HttpURLConnection connection, final Map<String, String> headers)
            throws IOException {
        int status = connection.getResponseCode();
        boolean redirect =
                status == HttpURLConnection.HTTP_MOVED_TEMP
                || status == HttpURLConnection.HTTP_MOVED_PERM
                || status == HttpURLConnection.HTTP_SEE_OTHER
                || status == 307 /* HTTP_TEMP_REDIRECT */
                || status == 308 /* HTTP_PERM_REDIRECT */
                || (status == HttpURLConnection.HTTP_FORBIDDEN
                        && connection.getHeaderField("Location") != null);

        if (redirect) {
            String newUrl = connection.getHeaderField("Location");
            String cookies = connection.getHeaderField("Set-Cookie");

            if (newUrl == null && status == HttpURLConnection.HTTP_MOVED_PERM) {
                URL current = connection.getURL();
                String host = current.getHost();
                if (!host.startsWith("www.")) {
                    newUrl = current.getProtocol() + "://www." + host + current.getFile();
                }
            }

            if (newUrl == null) {
                return connection;
            }

            connection = (HttpURLConnection) new URL(newUrl).openConnection();
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    connection.setRequestProperty(header.getKey(), header.getValue());
                }
            }
            if (cookies != null) {
                connection.setRequestProperty("Cookie", cookies);
            }

            // Recursively follow further redirects if needed
            connection = redirect(connection, headers);
        }

        return connection;
    }

    private byte[] readStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];
        for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
            baos.write(buffer, 0, len);
        }
        return baos.toByteArray();
    }

    private boolean isClientChallenge(String html) {
        return html != null && html.contains("<title>Client Challenge</title>");
    }

    private void logDownloadError(String url, IOException ex) {
        if (isHttp403(ex)) {
            LOGGER.severe("Cannot download " + url + " with direct connection. " + ex.getMessage());
        } else {
            LOGGER.log(Level.SEVERE, "Cannot download " + url + " with direct connection.", ex);
        }
    }

    private boolean isHttp403(IOException ex) {
        return ex.getMessage() != null && ex.getMessage().contains("403");
    }

    private boolean isSslException(IOException ex) {
        Throwable t = ex;
        while (t != null) {
            if (t instanceof javax.net.ssl.SSLException) {
                return true;
            }
            t = t.getCause();
        }
        return false;
    }
}
