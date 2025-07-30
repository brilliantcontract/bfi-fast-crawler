package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ConcatenatedEmailExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testConcatenatedEmailsAreIgnored() {
        String html = "ricky1rodgers@aamou.org Director630-606-1910ricky1rodgers@aamou.org "
                + "WilsonPresidentiwilson@aamou.org iwilson@aamou.org rryder@aamou.org "
                + "Facilitatorrryder@aamou.org Facilitatorjgreer@aamou.org jgreer@aamou.org "
                + "erodgers@aamou.org Coordinatorehowell@aamou.org ehowell@aamou.org";
        String emails = parser.extractEmail(html);
        assertThat(emails, is("ricky1rodgers@aamou.org\u25d9iwilson@aamou.org\u25d9rryder@aamou.org\u25d9jgreer@aamou.org\u25d9erodgers@aamou.org\u25d9ehowell@aamou.org"));
    }
}
