package bc.bfi.crawler;

import bc.bfi.crawler.Downloader;
import bc.bfi.crawler.Parser;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class BugFixAhfincNetTest {

    private static final String URL = "ahfinc.net";

    private final Downloader downloader = new Downloader();
    private final Parser parser = new Parser();

    @Ignore("Requires network access and ScrapeNinja fails to download it")
    @Test
    public void testExtractContactFormUrl() {
        String page = downloader.load(URL);
        String contactFormUrl = parser.extractContactPageUrl(page, "https://ahfinc.net");
        
        assertThat(contactFormUrl, containsString("https://ahfinc.net/contact-us"));
    }

}
