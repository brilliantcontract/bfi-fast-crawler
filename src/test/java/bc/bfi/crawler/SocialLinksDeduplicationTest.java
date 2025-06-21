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
}
