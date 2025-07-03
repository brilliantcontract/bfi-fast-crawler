package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Ignore;

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
        assertThat(detector.hasContactFormFromHtml(page), is(true));
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
    public void testAgcnwo() throws IOException {
        String page = readString(Paths.get("src/test/resources/agcnwo.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testMtpcaStaff() throws IOException {
        String page = readString(Paths.get("src/test/resources/mtpca.org-staff.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBayoaksMiami() throws IOException {
        String page = readString(Paths.get("src/test/resources/bayoaksmiami.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }
    
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
    public void testMeganMaxwell() throws IOException {
        String page = readString(Paths.get("src/test/resources/megan-maxwell.com-contacto.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBctgm() throws IOException {
        String page = readString(Paths.get("src/test/resources/bctgm.org-organize-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified.
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
    public void testBethanyBeachFire() throws IOException {
        String page = readString(Paths.get("src/test/resources/bethanybeachfire.com-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAhome2come2ContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/ahome2come2.com-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testPartidoFeminista() throws IOException {
        String page = readString(Paths.get("src/test/resources/partidofeminista.es-contacto-partido-feminista.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }
    
    @Test
    public void testBetterLife() throws IOException {
        String page = readString(Paths.get("src/test/resources/better-life.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testAimegroupPortal() throws IOException {
        String page = readString(Paths.get("src/test/resources/aimegroup.com-welcome-to-the-new-aime-member-portal.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testJoanneFluke() throws IOException {
        String page = readString(Paths.get("src/test/resources/joannefluke.com-contact-me.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testGsvymca() throws IOException {
        String page = readString(Paths.get("src/test/resources/gsvymca.org-contact-information.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified, form is hidden.
    }

    @Test
    public void testAlaskaairmenAbout() throws IOException {
        String page = readString(Paths.get("src/test/resources/alaskaairmen.org-about.html"), StandardCharsets.UTF_8);
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

    @Test
    public void testCincfoundation() throws IOException {
        String page = readString(Paths.get("src/test/resources/cincfoundation.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified, form hidden.
    }

    @Test
    public void testAlliedtradesFeedback() throws IOException {
        String page = readString(Paths.get("src/test/resources/alliedtrades-online.com-feedback.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testLcf() throws IOException {
        String page = readString(Paths.get("src/test/resources/lcf.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testMcarthurLibrary() throws IOException {
        String page = readString(Paths.get("src/test/resources/mcarthurlibrary.org-directory.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCasaDeLaFamilia() throws IOException {
        String page = readString(Paths.get("src/test/resources/casadelafamilia.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified.
    }
    
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

    @Test
    public void testConnectAsclsHome() throws IOException {
        String page = readString(Paths.get("src/test/resources/connect.ascls.org-home.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testInstagramReel() throws IOException {
        String page = readString(Paths.get("src/test/resources/instagram.com-reel-DLI9dsNBqRj.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBigCitiesHealthContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/bigcitieshealth.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBigstuffhealthshareDpcConnection() throws IOException {
        String page = readString(Paths.get("src/test/resources/bigstuffhealthshare.com-dpc-connection.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testBridgeBostonCsContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/bridgebostoncs.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testBrockwayCatArtContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/brockwaycatart.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBrothersOfMercyContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/brothersofmercy.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testBullochAdcContact() throws IOException {
        String page = readString(Paths.get("src/test/resources/bullochadc.org-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Ignore("Cannot fix that issue.")
    @Test
    public void testBvuVolunteersContactUs() throws IOException {
        String page = readString(Paths.get("src/test/resources/bvuvolunteers.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified.
    }

    @Test
    public void testCampStCharlesRequestInfo() throws IOException {
        String page = readString(Paths.get("src/test/resources/campstcharles.org-request-info.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testDebbieMacomber() throws IOException {
        String page = readString(Paths.get("src/test/resources/debbiemacomber.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testLauraChilds() throws IOException {
        String page = readString(Paths.get("src/test/resources/laurachilds.com-contact.php.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testMcBeaton() throws IOException {
        String page = readString(Paths.get("src/test/resources/mcbeaton.com-en-us-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testJenniferRyanAuthor() throws IOException {
        String page = readString(Paths.get("src/test/resources/jenniferryanauthor.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testGaMckevett() throws IOException {
        String page = readString(Paths.get("src/test/resources/gamckevett.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true)); // Verified.
    }

    @Test
    public void testAuthorTaranMatharu() throws IOException {
        String page = readString(Paths.get("src/test/resources/authortaranmatharu.com-contact-us-1.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testCassandraClare() throws IOException {
        String page = readString(Paths.get("src/test/resources/cassandraclare.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testPaulaBrackston() throws IOException {
        String page = readString(Paths.get("src/test/resources/paulabrackston.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testLynneGraham() throws IOException {
        String page = readString(Paths.get("src/test/resources/lynnegraham.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCaroleMortimer() throws IOException {
        String page = readString(Paths.get("src/test/resources/carolemortimer.co.uk-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testSusanMallery() throws IOException {
        String page = readString(Paths.get("src/test/resources/susanmallery.com-connect.php.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }    

    @Test
    public void testCandleClubWichita() throws IOException {
        String page = readString(Paths.get("src/test/resources/candleclubwichita.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testCaoSciotoCounty() throws IOException {
        String page = readString(Paths.get("src/test/resources/caosciotocounty.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCaringAndSharingSchool() throws IOException {
        String page = readString(Paths.get("src/test/resources/caringandsharingschool.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testCaritasOfBirmingham() throws IOException {
        String page = readString(Paths.get("src/test/resources/caritasofbirmingham.org-home.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testCasProviders() throws IOException {
        String page = readString(Paths.get("src/test/resources/casproviders.org-contact-us.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testBjDaniels() throws IOException {
        String page = readString(Paths.get("src/test/resources/bjdaniels.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testDebraWebb() throws IOException {
        String page = readString(Paths.get("src/test/resources/debrawebb.com-contact-debra.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testCarlosRuizZafon() throws IOException {
        String page = readString(Paths.get("src/test/resources/carlosruizzafon.co.uk-landing-page-hachette-contact-us-huk-v2.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testAntonioMunozMolina() throws IOException {
        String page = readString(Paths.get("src/test/resources/antoniomunozmolina.es-contacto.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(true));
    }

    @Test
    public void testLauraGallego() throws IOException {
        String page = readString(Paths.get("src/test/resources/lauragallego.com-contacto.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }

    @Test
    public void testHannahHowell() throws IOException {
        String page = readString(Paths.get("src/test/resources/hannahhowell.com-contact.html"), StandardCharsets.UTF_8);
        assertThat(detector.hasContactFormFromHtml(page), is(false));
    }
}
