package bc.bfi.crawler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import org.junit.Test;

public class DownloaderWwwFallbackTest {

    @Test
    public void retriesWithWwwOnMovedPermanently() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        int port = server.getAddress().getPort();
        server.createContext("/", (HttpExchange exchange) -> {
            String host = exchange.getRequestHeaders().getFirst("Host");
            if (host != null && host.startsWith("www.")) {
                byte[] body = "with www".getBytes("UTF-8");
                exchange.sendResponseHeaders(200, body.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(body);
                }
            } else {
                byte[] body = "<html><head><title>301 Moved Permanently</title></head></html>".getBytes("UTF-8");
                exchange.sendResponseHeaders(301, body.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(body);
                }
            }
        });
        server.start();
        try {
            Downloader downloader = new Downloader();
            Method m = Downloader.class.getDeclaredMethod("loadWithDirectConnection", String.class);
            m.setAccessible(true);
            String content = (String) m.invoke(downloader, "http://localhost:" + port + "/");
            assertThat(content, containsString("with www"));
        } finally {
            server.stop(0);
        }
    }
}
