package bc.bfi.crawler;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SocialLinksParserAdditionalTest {

    private final Parser parser = new Parser();

    @Test
    public void testAdditionalNetworksAndAliases() {
        String html = "<html><body>"
                + "<a href='https://fb.com/example/'>FB1</a>"
                + "<a href='https://fb.me/example'>FB2</a>"
                + "<a href='https://m.facebook.com/example'>FB3</a>"
                + "<a href='https://reddit.com/user/u1'>R1</a>"
                + "<a href='https://redd.it/u1'>R2</a>"
                + "<a href='https://snapchat.com/add/testuser'>S1</a>"
                + "<a href='https://www.threads.net/@user'>T1</a>"
                + "</body></html>";

        String links = parser.extractSocialLinks(html);
        String[] arr = links.split("◙");
        assertThat(arr.length, is(4));
        assertThat(links, containsString("https://facebook.com/example"));
        assertThat(links, containsString("https://reddit.com/user/u1"));
        assertThat(links, containsString("https://snapchat.com/add/testuser"));
        assertThat(links, containsString("https://www.threads.net/@user"));
    }
}
