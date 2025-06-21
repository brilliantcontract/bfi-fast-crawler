package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ImageNamesExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testImageNamesAreIgnoredAsEmails() {
        String html = "<html><body>AGC_Logo_RGB-4@2x.png logo-white@2x.png 16@2x.png</body></html>";
        String emails = parser.extractEmail(html);
        assertThat(emails, is(""));
    }
}