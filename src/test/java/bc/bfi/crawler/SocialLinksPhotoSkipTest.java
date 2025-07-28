package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SocialLinksPhotoSkipTest {

    private final Parser parser = new Parser();

    @Test
    public void skipsFacebookPhotoLinks() {
        String html = "<html><body>"
                + "<a href='https://www.facebook.com/photo.php?fbid=123'>P</a>"
                + "<a href='https://www.facebook.com/example'>U</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        assertThat(links, is("https://www.facebook.com/example"));
    }
}
