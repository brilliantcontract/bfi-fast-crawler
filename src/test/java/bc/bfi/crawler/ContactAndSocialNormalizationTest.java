package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ContactAndSocialNormalizationTest {

    private final Parser parser = new Parser();

    @Test
    public void testContactUrlNoTrailingSlash() {
        String html = "<html><body>"
                + "<a href='https://example.com/contact/'>Contact</a>"
                + "</body></html>";
        String url = "https://example.com";
        String contactUrl = parser.extractContactPageUrl(html, url);
        assertThat(contactUrl, is("https://example.com/contact"));
    }

    @Test
    public void testSocialLinkNoTrailingSlash() {
        String html = "<html><body>"
                + "<a href='https://facebook.com/example/'>FB</a>"
                + "</body></html>";
        String links = parser.extractSocialLinks(html);
        assertThat(links, is("https://www.facebook.com/example"));
    }
}
