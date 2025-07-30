package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Method;
import org.junit.Test;

public class ScrapeNinjaResponseParsingTest {

    @Test
    public void extractsBodyFromJson() throws Exception {
        String json = "{\"info\":{\"version\":\"1\"},\"body\":\"<html>Hello</html>\"}";
        Downloader downloader = new Downloader();
        Method m = Downloader.class.getDeclaredMethod("extractBodyFromScrapeNinjaResponse", String.class);
        m.setAccessible(true);
        String body = (String) m.invoke(downloader, json);
        assertThat(body, is("<html>Hello</html>"));
    }
}
