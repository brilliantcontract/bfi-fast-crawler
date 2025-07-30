package bc.bfi.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

public class TestScrapeNinja {

    private final static String SCRAPENINJA_API_KEY = "602cc2a1femsh9bacd616bc8c076p1b5c9fjsn050eedb6ce7b";

    @Ignore
    @Test
    public void test() throws IOException {
        String page = loadWithScrapeNinja("https://myip.wtf");

        System.out.println(page);
        assertThat(page, containsString("<body>"));
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
        }
        return json;
    }

}
