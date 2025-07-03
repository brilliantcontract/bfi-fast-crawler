package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PhoneFormatDeduplicationTest {

    private final Parser parser = new Parser();

    @Test
    public void testDuplicateNumbersInDifferentFormats() {
        String html = "call 260-420-6945 or (260) 420-6945 or 1 (260)420-6945";
        String phones = parser.extractPhone(html);
        assertThat(phones, is("(260) 420-6945"));
    }
}
