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
    public void testIreneZoeAlameda() throws IOException {
        String page = readString(Paths.get("src/test/resources/irenezoealameda.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testMeganMaxwell() throws IOException {
        String page = readString(Paths.get("src/test/resources/megan-maxwell.com-contacto.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testUgr() throws IOException {
        String page = readString(Paths.get("src/test/resources/ugr.es-enviar-mensaje.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testNuriaAmat() throws IOException {
        String page = readString(Paths.get("src/test/resources/nuriaamat.com-contacto.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testPartidoFeminista() throws IOException {
        String page = readString(Paths.get("src/test/resources/partidofeminista.es-contacto-partido-feminista.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testJoanneFluke() throws IOException {
        String page = readString(Paths.get("src/test/resources/joannefluke.com-contact-me.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testKarenRobards() throws IOException {
        String page = readString(Paths.get("src/test/resources/karenrobards.com-connect.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testRobertCrais() throws IOException {
        String page = readString(Paths.get("src/test/resources/robertcrais.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testSaraparetsky() throws IOException {
        String page = readString(Paths.get("src/test/resources/saraparetsky.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testJuliaQuinn() throws IOException {
        String page = readString(Paths.get("src/test/resources/juliaquinn.com-mediakit.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testJanetDailey() throws IOException {
        String page = readString(Paths.get("src/test/resources/janetdailey.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }
}
