package bc.bfi.crawler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.junit.Test;

public class DownloaderSslFallbackTest {

    @Test
    public void fallsBackToHttpWhenHttpsFails() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        int port = server.getAddress().getPort();
        server.createContext("/", (HttpExchange exchange) -> {
            byte[] body = "plain-http".getBytes("UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
        try {
            Downloader downloader = new Downloader();
            String content = downloader.load("https://localhost:" + port + "/");
            assertThat(content, containsString("plain-http"));
            assertThat(downloader.wasScrapeNinjaUsed(), is(false));
        } finally {
            server.stop(0);
        }
    }
}
