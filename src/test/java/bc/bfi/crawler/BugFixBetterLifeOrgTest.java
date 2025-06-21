package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class BugFixBetterLifeOrgTest {

    private final Parser parser = new Parser();

    @Test
    public void testExtractContactPageUrl() throws IOException {
        String page = new String(Files.readAllBytes(Paths.get("src/test/resources/better-life-home.html")), StandardCharsets.UTF_8);
        String contactFormUrl = parser.extractContactPageUrl(page, "https://better-life.org");
        assertThat(contactFormUrl, is("https://better-life.org/contact"));
    }
}
