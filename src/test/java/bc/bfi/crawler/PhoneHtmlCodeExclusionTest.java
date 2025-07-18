package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PhoneHtmlCodeExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testPhoneInScriptIgnored() {
        String html = "<html><head><script>var tel='123-456-7890';</script></head><body></body></html>";
        String phones = parser.extractPhone(html);
        assertThat(phones, is(""));
    }

    @Test
    public void testPhoneInStyleIgnored() {
        String html = "<html><head><style>.x{content:'123-456-7890';}</style></head><body></body></html>";
        String phones = parser.extractPhone(html);
        assertThat(phones, is(""));
    }

    @Test
    public void testPhoneInAttributeIgnored() {
        String html = "<div data-phone='123-456-7890'>Call</div>";
        String phones = parser.extractPhone(html);
        assertThat(phones, is(""));
    }
}
