package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SocialLinksDeduplicationTest {

    private final Parser parser = new Parser();

    @Test
    public void testUniqueSocialLinks() {
        String html = "<html><body>"
                + "<a href='https://facebook.com/example/'>FB1</a>"
                + "<a href='https://facebook.com/example'>FB2</a>"
                + "<a href='https://twitter.com/user'>TW1</a>"
                + "<a href='https://twitter.com/user'>TW2</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        assertThat(links.split("◙").length, is(2));
    }

    @Test
    public void testLinksNormalizedWithWww() {
        String html = "<html><body>"
                + "<a href='https://facebook.com/example'>FB1</a>"
                + "<a href='https://www.facebook.com/example'>FB2</a>"
                + "<a href='http://twitter.com/user'>TW1</a>"
                + "<a href='https://www.twitter.com/user'>TW2</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        String[] parts = links.split("◙");
        assertThat(parts.length, is(2));
      
        // social links are normalized with "www" prefix
        assertThat(parts[0], is("https://www.facebook.com/example"));
        assertThat(parts[1], is("https://www.twitter.com/user"));
    }
}
