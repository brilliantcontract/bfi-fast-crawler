package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PhoneExtractionFromHtmlTest {

    private final Parser parser = new Parser();

    private static String readString(Path path, java.nio.charset.Charset charset) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, charset);
    }

    @Test
    public void testAclcPhones() throws IOException {
        String html = readString(Paths.get("src/test/resources/aclc.org-contact.html"), StandardCharsets.UTF_8);
        String phones = parser.extractPhone(html);
        assertThat(phones, is("(305) 651-6617\u25d9(305) 888-7858\u25d9(904) 356-4888\u25d9(904) 355-3001\u25d9(813) 319-0705"));
    }

    @Test
    public void testAfscmeflPhones() throws IOException {
        String html = readString(Paths.get("src/test/resources/afscmefl.org-contact-us.html"), StandardCharsets.UTF_8);
        String phones = parser.extractPhone(html);
        assertThat(phones, is("(606) 633-3929\u25d9(877) 637-3929\u25d9(606) 633-3925"));
    }
}
