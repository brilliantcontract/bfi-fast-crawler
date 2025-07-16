package bc.bfi.crawler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import org.junit.Test;

public class DownloaderRedirectTest {

    @Test
    public void handlesHttpTempRedirect() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        int port = server.getAddress().getPort();
        server.createContext("/", (HttpExchange exchange) -> {
            exchange.getResponseHeaders().add("Location", "http://localhost:" + port + "/target");
            exchange.sendResponseHeaders(307, -1);
            exchange.close();
        });
        server.createContext("/target", (HttpExchange exchange) -> {
            byte[] body = "redirected".getBytes("UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
        try {
            Downloader downloader = new Downloader();
            Method m = Downloader.class.getDeclaredMethod("loadWithDirectConnection", String.class);
            m.setAccessible(true);
            String content = (String) m.invoke(downloader, "http://localhost:" + port + "/");
            assertThat(content, containsString("redirected"));
        } finally {
            server.stop(0);
        }
    }
}
