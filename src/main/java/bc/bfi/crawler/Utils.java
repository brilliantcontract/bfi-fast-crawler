package bc.bfi.crawler;

import java.net.MalformedURLException;
import java.net.URL;

class Utils {

    static String extractDomain(String inputUrl) {
        try {
            URL url = new URL(inputUrl);
            return url.getHost().replace("www.", "");
        } catch (MalformedURLException e) {
            return "";
        }
    }

    static String extractBaseUrl(String inputUrl) {
        try {
            URL url = new URL(inputUrl);
            String protocol = url.getProtocol();
            String host = url.getHost();
            return protocol + "://" + host;
        } catch (MalformedURLException e) {
            // Optional: handle URLs without protocol
            try {
                URL url = new URL("http://" + inputUrl);
                return "http://" + url.getHost();
            } catch (MalformedURLException ex) {
                return ""; // invalid URL
            }
        }
    }
}
