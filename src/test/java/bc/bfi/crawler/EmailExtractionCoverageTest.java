package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class EmailExtractionCoverageTest {

    private final Parser parser = new Parser();

    private static String readString(Path path, java.nio.charset.Charset charset) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, charset);
    }

    @Test
    public void test317Main() throws IOException {
        String html = readString(Paths.get("src/test/resources/317main.org-contact.html"), StandardCharsets.UTF_8);
        String emails = parser.extractEmail(html);
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(
                "register@317main.org",
                "alicia@317main.org"));
        Set<String> actual = Arrays.stream(emails.split("◙"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        assertThat(actual.containsAll(expected), is(true));
    }

    @Test
    public void testAamou() throws IOException {
        String html = readString(Paths.get("src/test/resources/aamou.org-get-involved.html"), StandardCharsets.UTF_8);
        String emails = parser.extractEmail(html);
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(
                "ricky1rodgers@aamou.org",
                "iwilson@aamou.org",
                "rryder@aamou.org",
                "jgreer@aamou.org",
                "ehowell@aamou.org"));
        Set<String> actual = Arrays.stream(emails.split("◙"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        assertThat(actual.containsAll(expected), is(true));
    }

    @Test
    public void testAbolitionistLawCenter() throws IOException {
        String html = readString(Paths.get("src/test/resources/abolitionistlawcenter.org-contact-us.html"), StandardCharsets.UTF_8);
        String emails = parser.extractEmail(html);
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(
                "info@alcenter.org",
                "comms@alcenter.org",
                "development@alcenter.org"));
        Set<String> actual = Arrays.stream(emails.split("◙"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        assertThat(actual.containsAll(expected), is(true));
    }

    @Test
    public void testAfscmefl() throws IOException {
        String html = readString(Paths.get("src/test/resources/afscmefl.org-contact-us.html"), StandardCharsets.UTF_8);
        String emails = parser.extractEmail(html);
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(
                "AFSCME.Florida@gmail.com",
                "info@afscmefl.org",
                "press@afscmefl.org"));
        Set<String> actual = Arrays.stream(emails.split("◙"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        assertThat(actual.containsAll(expected), is(true));
    }
}
