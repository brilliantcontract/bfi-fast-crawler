package bc.bfi.crawler;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void testExtractPhoneRemovesDuplicates() {
        bc.bfi.crawler.Parser parser = new bc.bfi.crawler.Parser();
        String html = "Contact 123-456-7890 or 456-7890 call 123-456-7890";
        String phones = parser.extractPhone(html);
        assertEquals("", phones);
    }
}
