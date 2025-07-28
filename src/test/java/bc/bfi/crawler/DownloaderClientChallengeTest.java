package bc.bfi.crawler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.junit.Test;

public class DownloaderClientChallengeTest {

    @Test
    public void retriesWithScrapeNinjaWhenClientChallenge() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        int port = server.getAddress().getPort();
        server.createContext("/", (HttpExchange exchange) -> {
            byte[] body = "<html><head><title>Client Challenge</title></head><body></body></html>".getBytes("UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
        try {
            Downloader downloader = new Downloader();
            downloader.load("http://localhost:" + port + "/");
            assertThat(downloader.wasScrapeNinjaUsed(), is(true));
        } finally {
            server.stop(0);
        }
    }
}
