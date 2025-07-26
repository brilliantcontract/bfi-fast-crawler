package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DomainExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testExcludedDomainsAreIgnored() {
        String html = "info@domain.com user@sentry.io admin@myftpupload.com good@example.com";
        String emails = parser.extractEmail(html);
        assertThat(emails, is("good@example.com"));
    }
}
