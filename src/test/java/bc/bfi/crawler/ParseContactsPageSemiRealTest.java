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
        assertThat(contact, is("https://aamou.org/get-involved/#contact-us"));
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
        assertThat(contact, is("https://www.cedf.com/inquiry"));
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
        assertThat(contact, is("https://www.instagram.com/bctgm"));
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
        assertThat(contact, is("https://www.mtbscc.org"));
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
        assertThat(contact, is("https://www.alliedtrades-online.com/feedback"));
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
        assertThat(contact, is("https://www.instagram.com/reel/DLI9dsNBqRj"));
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
        assertThat(contact, is("https://www.bigstuffhealthshare.com/contact"));
    }

    @Test
    public void testBridgeBostoncs() throws IOException {
        String page = readString(Paths.get("src/test/resources/bridgebostoncs.org-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://bridgebostoncs.org");
        assertThat(contact, is("https://www.bridgebostoncs.org/contact-us"));
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
        assertThat(contact, is("https://campstcharles.orgrequest-info.php"));
    }

    @Test
    public void testCandleClubWichita() throws IOException {
        String page = readString(Paths.get("src/test/resources/candleclubwichita.com-home.html"), StandardCharsets.UTF_8);
        String contact = parser.extractContactPageUrl(page, "https://candleclubwichita.com");
        assertThat(contact, is("https://candleclubwichita.comcontact"));
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
}
