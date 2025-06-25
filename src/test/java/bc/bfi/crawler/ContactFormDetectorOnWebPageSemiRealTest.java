package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ContactFormDetectorOnWebPageSemiRealTest {

    private final ContactFormDetector detector = new ContactFormDetector();

    private static String readString(Path path, java.nio.charset.Charset charset) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, charset);
    }

    @Test
    public void testGreaterFortWayneInc() throws IOException {
        String page = readString(Paths.get("src/test/resources/greaterfortwayneinc.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void test317Main() throws IOException {
        String page = readString(Paths.get("src/test/resources/317main.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAamou() throws IOException {
        String page = readString(Paths.get("src/test/resources/aamou.org-get-involved.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAaUnitedWay() throws IOException {
        String page = readString(Paths.get("src/test/resources/aaunitedway.org-contactus.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAbolitionistLawCenter() throws IOException {
        String page = readString(Paths.get("src/test/resources/abolitionistlawcenter.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAclc() throws IOException {
        String page = readString(Paths.get("src/test/resources/aclc.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAcvo() throws IOException {
        String page = readString(Paths.get("src/test/resources/acvo.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAfscmefl() throws IOException {
        String page = readString(Paths.get("src/test/resources/afscmefl.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCedf() throws IOException {
        String page = readString(Paths.get("src/test/resources/cedf.com-inquiry.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCastleHillsSchool() throws IOException {
        String page = readString(Paths.get("src/test/resources/chfbc.client.renweb.com-inquiry.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testMtpcaStaff() throws IOException {
        String page = readString(Paths.get("src/test/resources/mtpca.org-staff.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testSunyNiagaraSbdc() throws IOException {
        String page = readString(Paths.get("src/test/resources/sunyniagara.edu-sbdc.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAhfincContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/ahfinc.net-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAhome2come2ContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/ahome2come2.com-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAimegroupPortal() throws IOException {
        String page = readString(Paths.get("src/test/resources/aimegroup.com-welcome-to-the-new-aime-member-portal.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAlaskaairmenAbout() throws IOException {
        String page = readString(Paths.get("src/test/resources/alaskaairmen.org-about.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAlliedtradesFeedback() throws IOException {
        String page = readString(Paths.get("src/test/resources/alliedtrades-online.com-feedback.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAmicstlContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/amicstl.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testArcadiaContact() throws IOException {
        String page = readString(Paths.get("src/test/resources/arcadia.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAriseEducationalCenterContact() throws IOException {
        String page = readString(Paths.get("src/test/resources/ariseeducationalcenter.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }
}
