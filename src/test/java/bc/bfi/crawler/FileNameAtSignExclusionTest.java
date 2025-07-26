package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class FileNameAtSignExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testFileNamesWithAtAreIgnoredAsEmails() {
        String html = "<html><body>header@logo.jpg photo@image.jpeg graphic@icon.png</body></html>";
        String emails = parser.extractEmail(html);
        assertThat(emails, is(""));
    }
}
