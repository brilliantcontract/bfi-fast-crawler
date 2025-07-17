package bc.bfi.crawler;

import bc.bfi.crawler.Downloader;
import bc.bfi.crawler.Parser;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class BugFixAlaskaairmenOrgTest {

    private static final String URL = "alaskaairmen.org";

    private final Downloader downloader = new Downloader();
    private final Parser parser = new Parser();

    @Ignore("Requires network access")
    @Test
    public void testEmail() {
        String page = downloader.loadBaseUrl(URL);
        String emails = parser.extractEmail(page);
        
        assertThat(emails, containsString("info@alaskaairmen.org"));
        assertThat(emails, containsString("20info@alaskaairmen.org"));
        assertThat(emails.split("◙").length, is(2));
    }

}
