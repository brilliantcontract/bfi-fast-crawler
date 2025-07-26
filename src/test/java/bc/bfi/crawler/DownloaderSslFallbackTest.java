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
        Downloader downloader = new Downloader();
        String content = downloader.load("https://donnaandrews.com");
        assertThat(content, containsString("<title>Donna Andrews</title>"));
        assertThat(downloader.wasScrapeNinjaUsed(), is(false));
    }
}
