package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.Ignore;

import java.nio.file.Path;

public class ParseContactsPageSemiRealTest {

    private final Parser parser = new Parser();

    private static String readString(Path path, java.nio.charset.Charset charset) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, charset);
    }

    @Test
    public void testGreaterFortWayneInc() throws IOException {
        String page = readString(Paths.get("src/test/resources/greaterfortwayneinc.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://greaterfortwayneinc.com");
        assertThat(contact, is("https://www.greaterfortwayneinc.com/chamber/benefits/connect"));
    }

    @Test
    public void test317Main() throws IOException {
        String page = readString(Paths.get("src/test/resources/317main.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://317main.org");
        assertThat(contact, is("https://317main.org/contact"));
    }

    @Test
    public void testAamou() throws IOException {
        String page = readString(Paths.get("src/test/resources/aamou.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aamou.org");
        assertThat(contact, is("https://aamou.org/get-involved#contact-us"));
    }

    @Test
    public void testAaUnitedWay() throws IOException {
        String page = readString(Paths.get("src/test/resources/aaunitedway.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aaunitedway.org");
        assertThat(contact, is("https://www.aaunitedway.org/contactus"));
    }

    @Test
    public void testAbolitionistLawCenter() throws IOException {
        String page = readString(Paths.get("src/test/resources/abolitionistlawcenter.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://abolitionistlawcenter.org");
        assertThat(contact, is("https://abolitionistlawcenter.org/contact-us"));
    }

    @Test
    public void testAclc() throws IOException {
        String page = readString(Paths.get("src/test/resources/aclc.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aclc.org");
        assertThat(contact, is("https://aclc.org/contact"));
    }

    @Test
    public void testAcvo() throws IOException {
        String page = readString(Paths.get("src/test/resources/acvo.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://acvo.org");
        assertThat(contact, is("https://acvo.org/contact"));
    }

    @Test
    public void testAerialRecovery() throws IOException {
        String page = readString(Paths.get("src/test/resources/aerialrecovery.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aerialrecovery.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testAfscmefl() throws IOException {
        String page = readString(Paths.get("src/test/resources/afscmefl.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://afscmefl.org");
        assertThat(contact, is("https://afscmefl.org/contact-us"));
    }

    @Test
    public void testCedf() throws IOException {
        String page = readString(Paths.get("src/test/resources/cedf.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cedf.com");
        assertThat(contact, is("https://cedf.com/contact"));
    }

    @Test
    public void testCastleHillsSchool() throws IOException {
        String page = readString(Paths.get("src/test/resources/castlehills.school-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://castlehills.school");
        assertThat(contact, is("https://chfbc.client.renweb.com/oa/inquiry.cfm?memberid=362"));
    }

    @Test
    public void testCfchildren() throws IOException {
        String page = readString(Paths.get("src/test/resources/cfchildren.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cfchildren.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testAgcnwo() throws IOException {
        String page = readString(Paths.get("src/test/resources/agcnwo.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://agcnwo.com");
        assertThat(contact, is("https://agcnwo.com/contact"));
    }

    @Test
    public void testAgforestry() throws IOException {
        String page = readString(Paths.get("src/test/resources/agforestry.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://agforestry.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testBayoaksmiami() throws IOException {
        String page = readString(Paths.get("src/test/resources/bayoaksmiami.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bayoaksmiami.com");
        assertThat(contact, is("https://bayoaksmiami.com/contact"));
    }

    @Test
    public void testBctgm() throws IOException {
        String page = readString(Paths.get("src/test/resources/bctgm.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bctgm.org");
        assertThat(contact, is("https://bctgm.org/organize/contact"));
    }

    @Test
    public void testBethanyBeachFire() throws IOException {
        String page = readString(Paths.get("src/test/resources/bethanybeachfire.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bethanybeachfire.com");
        assertThat(contact, is("https://bethanybeachfire.com/contact-us"));
    }

    @Test
    public void testBetterLife() throws IOException {
        String page = readString(Paths.get("src/test/resources/better-life-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://better-life.org");
        assertThat(contact, is("https://better-life.org/contact"));
    }

    @Test
    public void testBigCatRescue() throws IOException {
        String page = readString(Paths.get("src/test/resources/bigcatrescue.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigcatrescue.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testGsvymca() throws IOException {
        String page = readString(Paths.get("src/test/resources/gsvymca.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://gsvymca.org");
        assertThat(contact, is("https://gsvymca.org/contact-information"));
    }

    @Test
    public void testCincfoundation() throws IOException {
        String page = readString(Paths.get("src/test/resources/cincfoundation.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cincfoundation.org");
        assertThat(contact, is("https://www.cincfoundation.org"));
    }

    @Test
    public void testLcf() throws IOException {
        String page = readString(Paths.get("src/test/resources/lcf.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lcf.org");
        assertThat(contact, is("https://lcf.org/contact"));
    }

    @Test
    public void testMcarthurlibrary() throws IOException {
        String page = readString(Paths.get("src/test/resources/mcarthurlibrary.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mcarthurlibrary.org");
        assertThat(contact, is("https://www.mcarthurlibrary.org/directory.html"));
    }

    @Test
    public void testCasadelafamilia() throws IOException {
        String page = readString(Paths.get("src/test/resources/casadelafamilia.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://casadelafamilia.org");
        assertThat(contact, is("https://casadelafamilia.org/contact-us"));
    }

    @Test
    public void testMtpca() throws IOException {
        String page = readString(Paths.get("src/test/resources/mtpca.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mtpca.org");
        assertThat(contact, is("https://www.mtpca.org/about/staff"));
    }

    @Ignore("Cannot download remote home page")
    @Test
    public void testNiagaracc() throws IOException {
        String page = readString(Paths.get("src/test/resources/niagaracc.suny.edu-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://niagaracc.suny.edu");
        assertThat(contact, is("https://sunyniagara.edu/sbdc"));
    }

    @Test
    public void testAhfincNet() throws IOException {
        String page = readString(Paths.get("src/test/resources/ahfinc.net-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ahfinc.net");
        assertThat(contact, is("https://ahfinc.net/contact-us"));
    }

    @Test
    public void testAhome2come2() throws IOException {
        String page = readString(Paths.get("src/test/resources/ahome2come2.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ahome2come2.com");
        assertThat(contact, is("http://ahome2come2.com/contact-us"));
    }

    @Test
    public void testAimegroup() throws IOException {
        String page = readString(Paths.get("src/test/resources/aimegroup.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://aimegroup.com");
        assertThat(contact, is("https:\\/\\/aimegroup.com\\/welcome-to-the-new-aime-member-portal\\"));
    }

    @Test
    public void testAlaskaairmen() throws IOException {
        String page = readString(Paths.get("src/test/resources/alaskaairmen.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://alaskaairmen.org");
        assertThat(contact, is("https://alaskaairmen.org/about"));
    }

    @Test
    public void testAlliedtradesOnline() throws IOException {
        String page = readString(Paths.get("src/test/resources/alliedtrades-online.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://alliedtrades-online.com");
        assertThat(contact, is("https://www.alliedtrades-online.com/contact"));
    }

    @Test
    public void testAmicstl() throws IOException {
        String page = readString(Paths.get("src/test/resources/amicstl.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://amicstl.org");
        assertThat(contact, is("https://amicstl.org/contact-us"));
    }

    @Test
    public void testArcadia() throws IOException {
        String page = readString(Paths.get("src/test/resources/arcadia.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://arcadia.org");
        assertThat(contact, is("https://arcadia.org/contact"));
    }

    @Test
    public void testAriseEducationalCenter() throws IOException {
        String page = readString(Paths.get("src/test/resources/ariseeducationalcenter.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ariseeducationalcenter.com");
        assertThat(contact, is("https://ariseeducationalcenter.com/contact"));
    }

    @Test
    public void testAscls() throws IOException {
        String page = readString(Paths.get("src/test/resources/ascls.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ascls.org");
        assertThat(contact, is("https://connect.ascls.org/home"));
    }

    @Test
    public void testAsenseofhome() throws IOException {
        String page = readString(Paths.get("src/test/resources/asenseofhome.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://asenseofhome.org");
        assertThat(contact, is("https://asenseofhome.org/contact"));
    }

    @Test
    public void testAzwater() throws IOException {
        String page = readString(Paths.get("src/test/resources/azwater.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://azwater.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testBigCitiesHealth() throws IOException {
        String page = readString(Paths.get("src/test/resources/bigcitieshealth.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigcitieshealth.org");
        assertThat(contact, is("https://www.bigcitieshealth.org/contact-us"));
    }

    @Test
    public void testBigStuffHealthShare() throws IOException {
        String page = readString(Paths.get("src/test/resources/bigstuffhealthshare.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bigstuffhealthshare.com");
        assertThat(contact, is("https://bigstuffhealthshare.com/contact"));
    }

    @Test
    public void testBridgeBostoncs() throws IOException {
        String page = readString(Paths.get("src/test/resources/bridgebostoncs.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bridgebostoncs.org");
        assertThat(contact, is("https://bridgebostoncs.org/contact-us"));
    }

    @Test
    public void testBrockwayCat() throws IOException {
        String page = readString(Paths.get("src/test/resources/brockwaycat.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://brockwaycat.org");
        assertThat(contact, is("https://brockwaycatart.org/contact-us"));
    }

    @Test
    public void testBrothersOfMercy() throws IOException {
        String page = readString(Paths.get("src/test/resources/brothersofmercy.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://brothersofmercy.org");
        assertThat(contact, is("https://brothersofmercy.org/contact-us"));
    }

    @Test
    public void testBullochAdc() throws IOException {
        String page = readString(Paths.get("src/test/resources/bullochadc.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bullochadc.org");
        assertThat(contact, is("https://bullochadc.org/contact"));
    }

    @Test
    public void testBvuVolunteers() throws IOException {
        String page = readString(Paths.get("src/test/resources/bvuvolunteers.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bvuvolunteers.org");
        assertThat(contact, is("https://bvuvolunteers.org/contact-us"));
    }

    @Test
    public void testCampStCharles() throws IOException {
        String page = readString(Paths.get("src/test/resources/campstcharles.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://campstcharles.org");
        assertThat(contact, is("https://campstcharles.org/request-info.php"));
    }

    @Test
    public void testCandleClubWichita() throws IOException {
        String page = readString(Paths.get("src/test/resources/candleclubwichita.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://candleclubwichita.com");
        assertThat(contact, is("https://candleclubwichita.com/contact"));
    }

    @Test
    public void testCaoSciotoCounty() throws IOException {
        String page = readString(Paths.get("src/test/resources/caosciotocounty.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://caosciotocounty.org");
        assertThat(contact, is("https://www.caosciotocounty.org/contact-us"));
    }

    @Test
    public void testCaringAndSharingSchool() throws IOException {
        String page = readString(Paths.get("src/test/resources/caringandsharingschool.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://caringandsharingschool.com");
        assertThat(contact, is("https://www.caringandsharingschool.com/contact"));
    }

    @Test
    @Ignore("Cannot download remote home page")
    public void testCaritasOfBirmingham() throws IOException {
        String page = readString(Paths.get("src/test/resources/caritasofbirmingham.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "http://caritasofbirmingham.org");
        assertThat(contact, is(""));
    }

    @Test
    public void testCasProviders() throws IOException {
        String page = readString(Paths.get("src/test/resources/casproviders.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://casproviders.org");
        assertThat(contact, is("https://casproviders.org/contact-us"));
    }

    @Test
    public void testSofiarhei() throws IOException {
        String page = readString(Paths.get("src/test/resources/sofiarhei.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://sofiarhei.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testBjdaniels() throws IOException {
        String page = readString(Paths.get("src/test/resources/bjdaniels.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bjdaniels.com");
        assertThat(contact, is("https://bjdaniels.com/contact"));
    }

    @Test
    public void testDebraWebb() throws IOException {
        String page = readString(Paths.get("src/test/resources/debrawebb.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://debrawebb.com");
        assertThat(contact, is("https://debrawebb.com/contact-debra"));
    }

    @Test
    public void testElleryAdamsMysteries() throws IOException {
        String page = readString(Paths.get("src/test/resources/elleryadamsmysteries.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://elleryadamsmysteries.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testSuegrafton() throws IOException {
        String page = readString(Paths.get("src/test/resources/suegrafton.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://suegrafton.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testLorraineHeath() throws IOException {
        String page = readString(Paths.get("src/test/resources/lorraineheath.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lorraineheath.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testDonnaAndrews() throws IOException {
        String page = readString(Paths.get("src/test/resources/donnaandrews.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "http://donnaandrews.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testCarlosRuizzafon() throws IOException {
        String page = readString(Paths.get("src/test/resources/carlosruizzafon.co.uk-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://carlosruizzafon.co.uk");
        assertThat(contact, is("https://www.carlosruizzafon.co.uk/landing-page/hachette/contact-us-huk-v2"));
    }

    @Test
    public void testAntonioMunozMolina() throws IOException {
        String page = readString(Paths.get("src/test/resources/antoniomunozmolina.es-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://antoniomunozmolina.es");
        assertThat(contact, is("http://xn--antoniomuozmolina-nxb.es/contacto"));
    }

    @Test
    public void testLauraGallego() throws IOException {
        String page = readString(Paths.get("src/test/resources/lauragallego.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lauragallego.com");
        assertThat(contact, is("https://www.lauragallego.com/contacto"));
    }

    @Test
    public void testIreneZoeAlameda() throws IOException {
        String page = readString(Paths.get("src/test/resources/irenezoealameda.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://irenezoealameda.com");
        assertThat(contact, is("https://irenezoealameda.com/contact"));
    }

    @Test
    public void testMeganMaxwell() throws IOException {
        String page = readString(Paths.get("src/test/resources/megan-maxwell.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://megan-maxwell.com");
        assertThat(contact, is("https://megan-maxwell.com/contacto"));
    }

    @Test
    public void testUgr() throws IOException {
        String page = readString(Paths.get("src/test/resources/ugr.es-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://ugr.es");
        assertThat(contact, is("https://ugr.es/contacto/enviar-mensaje"));
    }

    @Test
    public void testNuriaAmat() throws IOException {
        String page = readString(Paths.get("src/test/resources/nuriaamat.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://nuriaamat.com");
        assertThat(contact, is("https://nuriaamat.com/contacto"));
    }

    @Test
    public void testPartidoFeminista() throws IOException {
        String page = readString(Paths.get("src/test/resources/partidofeminista.es-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://partidofeminista.es");
        assertThat(contact, is("https://partidofeminista.es/contacto-partido-feminista"));
    }

    @Test
    public void testMonicaPerezDelasHeras() throws IOException {
        String page = readString(Paths.get("src/test/resources/monicaperezdelasheras.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://monicaperezdelasheras.com");
        assertThat(contact, is(""));
    }

    public void testJoanneFluke() throws IOException {
        String page = readString(Paths.get("src/test/resources/joannefluke.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://joannefluke.com");
        assertThat(contact, is("https://joannefluke.com/contact-me"));
    }

    @Test
    public void testKarenRobards() throws IOException {
        String page = readString(Paths.get("src/test/resources/karenrobards.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://karenrobards.com");
        assertThat(contact, is("https://karenrobards.com/connect.html"));
    }

    @Test
    public void testKarenRoseBooks() throws IOException {
        String page = readString(Paths.get("src/test/resources/karenrosebooks.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://karenrosebooks.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testRobertcrais() throws IOException {
        String page = readString(Paths.get("src/test/resources/robertcrais.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://robertcrais.com");
        assertThat(contact, is("https://robertcrais.com/contact.htm"));
    }

    @Test
    public void testSaraparetsky() throws IOException {
        String page = readString(Paths.get("src/test/resources/saraparetsky.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://saraparetsky.com");
        assertThat(contact, is("https://saraparetsky.com/contact"));
    }

    @Test
    public void testRobertGalbraith() throws IOException {
        String page = readString(Paths.get("src/test/resources/robert-galbraith.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://robert-galbraith.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testJuliaQuinn() throws IOException {
        String page = readString(Paths.get("src/test/resources/juliaquinn.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://juliaquinn.com");
        assertThat(contact, is("https://juliaquinn.com/mediakit#contacts"));
    }

    @Test
    public void testKarenChance() throws IOException {
        String page = readString(Paths.get("src/test/resources/karenchance.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://karenchance.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testJkRowling() throws IOException {
        String page = readString(Paths.get("src/test/resources/jkrowling.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://www.jkrowling.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testKateCarlisle() throws IOException {
        String page = readString(Paths.get("src/test/resources/katecarlisle.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://katecarlisle.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testMichaelmcgarrity() throws IOException {
        String page = readString(Paths.get("src/test/resources/michaelmcgarrity.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://michaelmcgarrity.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testDebbieMacomber() throws IOException {
        String page = readString(Paths.get("src/test/resources/debbiemacomber.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://debbiemacomber.com");
        assertThat(contact, is("https://debbiemacomber.com/about/contact"));
    }

    public void testRickRiordan() throws IOException {
        String page = readString(Paths.get("src/test/resources/rickriordan.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://rickriordan.com");
        assertThat(contact, is("https://rickriordan.com/about/contact-information/"));
    }

    @Test
    public void testTerryGoodkind() throws IOException {
        String page = readString(Paths.get("src/test/resources/terrygoodkind.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://www.terrygoodkind.com");
        assertThat(contact, is("https://www.terrygoodkind.com"));
    }

    @Test
    public void testLauraChilds() throws IOException {
        String page = readString(Paths.get("src/test/resources/laurachilds.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://laurachilds.com");
        assertThat(contact, is("https://laurachilds.com/contact.php"));
    }

    @Test
    public void testMcbeaton() throws IOException {
        String page = readString(Paths.get("src/test/resources/mcbeaton.com-en-us-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mcbeaton.com/en-us");
        assertThat(contact, is("https://mcbeaton.com/en-us/contact-us"));
    }

    @Test
    public void testJenniferRyanAuthor() throws IOException {
        String page = readString(Paths.get("src/test/resources/jenniferryanauthor.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://jenniferryanauthor.com");
        assertThat(contact, is("https://www.jenniferryanauthor.com/contact"));
    }

    @Test
    public void testGamckevett() throws IOException {
        String page = readString(Paths.get("src/test/resources/gamckevett.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://gamckevett.com");
        assertThat(contact, is("https://www.gamckevett.com/contact"));
    }

    @Test
    public void testAuthortaranmatharu() throws IOException {
        String page = readString(Paths.get("src/test/resources/authortaranmatharu.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://authortaranmatharu.com");
        assertThat(contact, is("https://authortaranmatharu.com/contact-us-1"));
    }

    @Test
    public void testMariaduenas() throws IOException {
        String page = readString(Paths.get("src/test/resources/mariaduenas.es-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://mariaduenas.es");
        assertThat(contact, is(""));
    }

    @Test
    public void testNoraRoberts() throws IOException {
        String page = readString(Paths.get("src/test/resources/noraroberts.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://noraroberts.com");
        assertThat(contact, is("https://noraroberts.com/contact-us"));
    }

    @Test
    public void testNealAsher() throws IOException {
        String page = readString(Paths.get("src/test/resources/nealasher.co.uk-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://nealasher.co.uk");
        assertThat(contact, is(""));
    }

    @Test
    public void testTerryPratchettBooks() throws IOException {
        String page = readString(Paths.get("src/test/resources/terrypratchettbooks.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://www.terrypratchettbooks.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testJaviercacho() throws IOException {
        String page = readString(Paths.get("src/test/resources/javiercacho.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://javiercacho.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testCassandraClare() throws IOException {
        String page = readString(Paths.get("src/test/resources/cassandraclare.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://cassandraclare.com");
        assertThat(contact, is("https://cassandraclare.com/contact"));
    }

    @Test
    public void testPaulaBrackston() throws IOException {
        String page = readString(Paths.get("src/test/resources/paulabrackston.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://www.paulabrackston.com");
        assertThat(contact, is("https://www.paulabrackston.com/contact"));
    }

    @Test
    public void testLisaKleypas() throws IOException {
        String page = readString(Paths.get("src/test/resources/lisakleypas.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lisakleypas.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testStephanieLaurens() throws IOException {
        String page = readString(Paths.get("src/test/resources/stephanielaurens.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://stephanielaurens.com");
        assertThat(contact, is(""));
    }

    @Test
    public void testRosamontero() throws IOException {
        String page = readString(Paths.get("src/test/resources/rosamontero.es-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://rosamontero.es");
        assertThat(contact, is(""));
    }

    @Test
    public void testLynneGraham() throws IOException {
        String page = readString(Paths.get("src/test/resources/lynnegraham.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://lynnegraham.com");
        assertThat(contact, is("https://www.lynnegraham.com/contact"));
    }

    @Test
    public void testCaroleMortimer() throws IOException {
        String page = readString(Paths.get("src/test/resources/carolemortimer.co.uk-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://carolemortimer.co.uk");
        assertThat(contact, is("https://carolemortimer.co.uk/contact.html"));
    }

    @Test
    public void testSusanMallery() throws IOException {
        String page = readString(Paths.get("src/test/resources/susanmallery.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://susanmallery.com");
        assertThat(contact, is("https://susanmallery.com/members-contact-susan.php"));
    }

    @Test
    public void testJanetDailey() throws IOException {
        String page = readString(Paths.get("src/test/resources/janetdailey.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://janetdailey.com");
        assertThat(contact, is("https://janetdailey.com/contact"));
    }

    @Test
    public void testHannahHowell() throws IOException {
        String page = readString(Paths.get("src/test/resources/hannahhowell.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://hannahhowell.com");
        assertThat(contact, is("https://www.hannahhowell.com?page_id=81"));
    }
}
