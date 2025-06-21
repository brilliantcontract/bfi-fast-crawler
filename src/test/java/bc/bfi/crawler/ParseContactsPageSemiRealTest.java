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
    public void testBayoaksmiami() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bayoaksmiami.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bayoaksmiami.com");
        assertThat(contact, is("https://bayoaksmiami.com/contact/"));
    }

    @Test
    public void testBctgm() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bctgm.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bctgm.org");
        assertThat(contact, is("https://www.instagram.com/bctgm/"));
    }

    @Test
    public void testBethanyBeachFire() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bethanybeachfire.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bethanybeachfire.com");
        assertThat(contact, is("https://bethanybeachfire.com/contact-us/"));
    }

    @Test
    public void testBetterLife() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/better-life-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://better-life.org");
        assertThat(contact, is("https://better-life.org/contact/"));
    }

    @Test
    public void testBigCatRescue() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bigcatrescue.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigcatrescue.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testBigCitiesHealth() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bigcitieshealth.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigcitieshealth.org");
        assertThat(contact, is("https://www.bigcitieshealth.org/contact-us/"));
    }

    @Test
    public void testBigStuffHealthShare() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bigstuffhealthshare.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigstuffhealthshare.com");
        assertThat(contact, is("https://www.bigstuffhealthshare.com/contact"));
    }

    @Test
    public void testBridgeBostoncs() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/bridgebostoncs.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bridgebostoncs.org");
        assertThat(contact, is("https://www.bridgebostoncs.org/contact-us"));
    }

    @Test
    public void testBrockwayCat() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/brockwaycat.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://brockwaycat.org");
        assertThat(contact, is("https://brockwaycatart.org/contact-us/"));
    }
}
