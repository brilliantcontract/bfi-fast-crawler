package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class SocialLinksCoverageTest {

    private final Parser parser = new Parser();

    @Test
    public void testAllProvidedSocialLinksAreExtracted() {
        String[] urls = new String[]{
"https://facebook.com/greaterfortwayneinc",
"https://instagram.com/greaterfortwayneinc",
"https://linkedin.com/company/greater-fort-wayne-inc",
"https://twitter.com/greaterfwinc",
"https://facebook.com/317music",
"https://facebook.com/foxandthefiddle",
"https://instagram.com/317main",
"https://soundcloud.com/user-83776051-760585697",
"https://vimeo.com/user89279129",
"https://www.facebook.com/ricky.rodgers.54",
"https://twitter.com/theyouthmatter?lang=en",
"https://www.facebook.com/AAUnitedWay",
"https://www.instagram.com/aaunitedway/",
"https://www.linkedin.com/company/aaunitedway/",
"https://www.youtube.com/channel/UCqa6PpA0fCDbRKcs3xD8CvA",
"https://www.facebook.com/AbolitionistLawCenter/",
"https://www.instagram.com/abolitionistlc/",
"https://facebook.com/acvonationalserviceanimaleyeexam",
"https://instagram.com/acvoofficial",
"https://www.youtube.com/@AerialRecovery",
"https://www.instagram.com/aerialrecoverygroup/",
"https://facebook.com/AFSCMEFlorida",
"https://twitter.com/AFSCMEFL",
"https://instagram.com/afscme.florida",
"https://youtube.com/channel/UCkhGkJPiw80mnXdqeXgs38g",
"https://facebook.com/agcofnwo",
"https://linkedin.com/company/agcnwo",
"https://twitter.com/agcnw",
"https://x.com/agcnw",
"https://youtube.com/channel/uc--u7txqis0za-_6gxu6zka/playlists",
"https://facebook.com/agforestryleaders",
"https://twitter.com/agforestry",
"https://youtube.com/user/agforestry/videos",
"https://www.instagram.com/aimenational/",
"https://www.facebook.com/alaska.airmen/",
"https://www.youtube.com/@AlaskaAirmensAssociation",
"http://instagram.com/alaska.airmen",
"https://www.facebook.com/atradesassistanceprogram",
"https://www.linkedin.com/company/allied-trades-assistance-program",
"https://www.instagram.com/atap_eap/?hl=en",
"http://www.facebook.com/amic.stlouis",
"https://www.instagram.com/amicstl/",
"https://www.linkedin.com/company/AMICSTL",
"https://x.com/AMIC_STL",
"https://www.facebook.com/arcadiafamilyofcompanies/",
"https://www.instagram.com/arcadiafamilyofcompanies/",
"https://www.instagram.com/ariseec_sf/",
"https://www.facebook.com/ASCLS",
"https://twitter.com/ascls",
"https://www.instagram.com/iamascls/",
"https://www.linkedin.com/groups/57563/",
"https://www.youtube.com/channel/UC5EA2gaOOHQzrMjWaUtyncQ",
"https://www.facebook.com/ASenseofHomeOrg/",
"https://www.linkedin.com/company/a-sense-of-home-nonprofit",
"https://www.instagram.com/asenseofhomeorg/",
"https://www.youtube.com/user/ASenseOfHome",
"https://www.facebook.com/pages/AZ-Water-Association/355192481261617",
"https://twitter.com/AZWater_org",
"https://www.linkedin.com/groups?home=&gid=1832518",
"https://www.instagram.com/BayOaksMiami/",
"https://www.instagram.com/BayOaksMiami/",
"https://www.facebook.com/BCTGM",
"https://twitter.com/BCTGM",
"https://www.instagram.com/BCTGM/",
"https://www.facebook.com/BethanyBeachVolFireCo",
"https://www.instagram.com/bethanybeachfire",
"http://facebook.com/bigcatrescue",
"http://instagram.com/bigcatrescue",
"http://youtube.com/bigcatrescue",
"http://x.com/bigcatrescue",
"https://www.threads.net/@bigcatrescue",
"https://www.facebook.com/BigCitiesHealth",
"https://www.linkedin.com/company/big-cities-health-coalition/",
"https://twitter.com/BigCitiesHealth",
"https://www.youtube.com/@bigcitieshealth",
"https://www.facebook.com/bridgebostoncharterschool/",
"https://www.linkedin.com/company/bridge-boston-charter-school/about/",
"https://www.instagram.com/bridgebostoncharterschool/",
"https://www.facebook.com/BrockwayCAT/",
"https://twitter.com/brockwaycat",
"https://www.instagram.com/brockway_cat/",
"https://www.facebook.com/BrothersofMercyCampus/",
"https://www.instagram.com/brothersofmercy/",
"https://www.linkedin.com/company/the-brothers-of-mercy-wellness-campus/",
"https://www.youtube.com/channel/UCAmCbdESJg8Q9RimydlHX9A",
"https://www.facebook.com/bullochalcoholanddrugcouncil/",
"https://twitter.com/badc1974",
"http://www.facebook.com/pages/Camp-St-Charles/49276086935",
"https://twitter.com/CampStCharles",
"http://www.pinterest.com/CampStCharles",
"https://www.youtube.com/user/csclaurahall",
"https://facebook.com/candleclubwichita",
"https://twitter.com/candleclubict",
"https://facebook.com/caoscioto",
"https://facebook.com/caring-and-sharing-learning-school-175940372456682",
"https://facebook.com/medjugorje.apparitons",
"https://twitter.com/medjugorje_com",
"https://facebook.com/becca.marie.961",
"https://facebook.com/casproviders",
"https://instagram.com/casproviders",
"https://instagram.com/drbeccatagg",
"https://linkedin.com/company/council-of-autism-service-providers",
"https://twitter.com/casproviders",
"https://facebook.com/castlehills.school",
"https://facebook.com/castlehills.school/reviews",
"https://instagram.com/castlehills.school",
"https://youtube.com/thechristianschoolatcastlehills",
"https://facebook.com/cedf.ct",
"https://linkedin.com/company/committee-for-children",
"https://facebook.com/council-of-independent-nebraska-colleges-foundation-137256993024733",
"https://linkedin.com/company/council-of-independent-nebraska-colleges-foundation",
"https://facebook.com/lincolncommunityfoundation",
"https://twitter.com/linc_comm_fdn",
"https://facebook.com/mcarthurlibrary",
"https://instagram.com/mcarthurlibrary",
"https://youtube.com/channel/ucpgul7u7hekjvygiokq825a",
"https://facebook.com/casadelafamilia.org",
"https://instagram.com/casadelafamilia",
"https://linkedin.com/company/casa-de-la-familia",
"https://tiktok.com/@casadelafamilia",
"https://youtube.com/channel/ucmxcf0a14wqghij_ghm82og/featured",
"https://facebook.com/montanapca",
"https://instagram.com/montanaprimarycareassociation",
"https://facebook.com/sunyniagara",
"https://instagram.com/sunyniagara",
"https://twitter.com/sunyniagara",
"https://x.com/sunyniagara",
"https://youtube.com/user/niagaraccc"        };

        StringBuilder html = new StringBuilder("<html><body>");
        for (String u : urls) {
            html.append("<a href='").append(u).append("'>link</a>");
        }
        html.append("</body></html>");

        String result = parser.extractSocialLinks(html.toString());
        Set<String> actual = new LinkedHashSet<>(Arrays.asList(result.split("◙")));
        Set<String> expected = Arrays.stream(urls)
                .map(u -> u.endsWith("/") ? u.substring(0, u.length() - 1) : u)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(actual, is(expected));
    }
}
