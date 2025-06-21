package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import org.junit.Ignore;
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
    public void testCedf() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/cedf.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cedf.com");
        assertThat(contact, is("https://www.cedf.com/inquiry"));
    }

    @Test
    public void testCastleHillsSchool() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/castlehills.school-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://castlehills.school");
        assertThat(contact, is("https://chfbc.client.renweb.com/oa/inquiry.cfm?memberid=362"));
    }

    @Test
    public void testCfchildren() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/cfchildren.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cfchildren.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testGsvymca() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/gsvymca.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://gsvymca.org");
        assertThat(contact, is("https://gsvymca.org/contact-information"));
    }

    @Test
    public void testCincfoundation() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/cincfoundation.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cincfoundation.org");
        assertThat(contact, is("https://www.cincfoundation.org"));
    }

    @Test
    public void testLcf() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/lcf.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lcf.org");
        assertThat(contact, is("https://lcf.org/contact"));
    }

    @Test
    public void testMcarthurlibrary() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/mcarthurlibrary.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mcarthurlibrary.org");
        assertThat(contact, is("https://www.mcarthurlibrary.org/directory.html"));
    }

    @Test
    public void testCasadelafamilia() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/casadelafamilia.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://casadelafamilia.org");
        assertThat(contact, is("https://casadelafamilia.org/contact-us"));
    }

    @Test
    public void testMtpca() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/mtpca.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mtpca.org");
        assertThat(contact, is("https://www.mtbscc.org"));
    }

    @Ignore("Cannot download remote home page")
    @Test
    public void testNiagaracc() throws IOException {
        String page = Files.readString(Paths.get("src/test/resources/niagaracc.suny.edu-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://niagaracc.suny.edu");
        assertThat(contact, is("https://sunyniagara.edu/sbdc/"));
    }
}
