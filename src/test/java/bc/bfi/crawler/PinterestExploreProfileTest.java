package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PinterestExploreProfileTest {

    private final Parser parser = new Parser();

    @Test
    public void collectsExploreProfiles() {
        String html = "<html><body>"
                + "<a href='https://www.pinterest.com/explore/nora-roberts'>P</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        assertThat(links, is("https://www.pinterest.com/explore/nora-roberts"));
    }
}
