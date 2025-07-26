package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SocialLinksDomainRootSkipTest {

    private final Parser parser = new Parser();

    @Test
    public void testDomainOnlyLinksAreIgnored() {
        String html = "<html><body>"
                + "<a href='https://www.facebook.com'>F</a>"
                + "<a href='https://twitter.com/'>T</a>"
                + "<a href='https://www.instagram.com'>I</a>"
                + "<a href='https://www.linkedin.com'>L</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        assertThat(links, is(""));
    }
}
