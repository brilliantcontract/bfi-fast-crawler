package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ParseContactsPageSemiRealTest {

    private final Parser parser = new Parser();

    @Test
    public void testGreaterFortWayneInc() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/greaterfortwayneinc.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://greaterfortwayneinc.com");
        assertThat(contact, is("https://www.greaterfortwayneinc.com/chamber/benefits/connect"));
    }

    @Test
    public void test317Main() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/317main.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://317main.org");
        assertThat(contact, is("https://317main.org/contact"));
    }

    @Test
    public void testAamou() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/aamou.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aamou.org");
        assertThat(contact, is("https://aamou.org/get-involved/#contact-us"));
    }

    @Test
    public void testAaUnitedWay() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/aaunitedway.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aaunitedway.org");
        assertThat(contact, is("https://www.aaunitedway.org/contactus"));
    }

    @Test
    public void testAbolitionistLawCenter() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/abolitionistlawcenter.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://abolitionistlawcenter.org");
        assertThat(contact, is("https://abolitionistlawcenter.org/contact-us"));
    }

    @Test
    public void testAclc() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/aclc.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aclc.org");
        assertThat(contact, is("https://aclc.org/contact"));
    }

    @Test
    public void testAcvo() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/acvo.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://acvo.org");
        assertThat(contact, is("https://acvo.org/contact"));
    }

    @Test
    public void testAerialRecovery() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/aerialrecovery.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aerialrecovery.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testAfscmefl() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/afscmefl.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://afscmefl.org");
        assertThat(contact, is("https://afscmefl.org/contact-us"));
    }

    @Test
    public void testAgcnwo() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/agcnwo.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://agcnwo.com");
        assertThat(contact, is("https://agcnwo.com/contact"));
    }

    @Test
    public void testAgforestry() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/agforestry.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://agforestry.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testAhfincNet() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/ahfinc.net-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ahfinc.net");
        assertThat(contact, is("https://ahfinc.net/contact-us"));
    }

    @Test
    public void testAhome2come2() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/ahome2come2.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ahome2come2.com");
        assertThat(contact, is("http://ahome2come2.com/contact-us"));
    }

    @Test
    public void testAimegroup() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/aimegroup.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aimegroup.com");
        assertThat(contact, is("https:\\/\\/aimegroup.com\\/welcome-to-the-new-aime-member-portal\\"));
    }

    @Test
    public void testAlaskaairmen() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/alaskaairmen.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://alaskaairmen.org");
        assertThat(contact, is("https://alaskaairmen.org/about"));
    }

    @Test
    public void testAlliedtradesOnline() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/alliedtrades-online.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://alliedtrades-online.com");
        assertThat(contact, is("https://www.alliedtrades-online.com/feedback"));
    }

    @Test
    public void testAmicstl() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/amicstl.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://amicstl.org");
        assertThat(contact, is("https://amicstl.org/contact-us"));
    }

    @Test
    public void testArcadia() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/arcadia.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://arcadia.org");
        assertThat(contact, is("https://arcadia.org/contact"));
    }

    @Test
    public void testAriseEducationalCenter() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/ariseeducationalcenter.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ariseeducationalcenter.com");
        assertThat(contact, is("https://ariseeducationalcenter.com/contact"));
    }

    @Test
    public void testAscls() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/ascls.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ascls.org");
        assertThat(contact, is("https://connect.ascls.org/home"));
    }

    @Test
    public void testAsenseofhome() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/asenseofhome.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://asenseofhome.org");
        assertThat(contact, is("https://www.instagram.com/reel/DLI9dsNBqRj"));
    }

    @Test
    public void testAzwater() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/azwater.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://azwater.org");
        assertThat(contact, is(""));
    }
}
