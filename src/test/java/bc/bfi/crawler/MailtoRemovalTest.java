package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class MailtoRemovalTest {

    private final Parser parser = new Parser();

    @Test
    public void testMailtoPrefixIsRemoved() {
        String html = "<html><body><a href='mailto:info@example.com'>Email</a></body></html>";
        String emails = parser.extractEmail(html);
        assertThat(emails, is("info@example.com"));
    }
}
