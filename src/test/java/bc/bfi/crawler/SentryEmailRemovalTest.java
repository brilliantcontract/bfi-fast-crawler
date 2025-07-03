package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SentryEmailRemovalTest {

    private final Parser parser = new Parser();

    @Test
    public void testSentryEmailsAreIgnored() {
        String html = "contact@mail.com 605a7baede844d278b89dc95ae0a9123@sentry-next.wixpress.com ed436f5053144538958ad06a5005e99a@sentry.wixpress.com";
        String emails = parser.extractEmail(html);
        assertThat(emails, is("contact@mail.com"));
    }
}
