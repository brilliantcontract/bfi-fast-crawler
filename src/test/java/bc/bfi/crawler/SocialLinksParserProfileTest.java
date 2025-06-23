package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class SocialLinksParserProfileTest {

    private final Parser parser = new Parser();

    @Test
    public void testAuthorProfileLinks() {
        String[] urls = new String[]{
            "https://www.facebook.com/AuthorKarenRobards",
            "https://twitter.com/thekarenrobards",
            "https://www.facebook.com/profile.php?id=100058056520669",
            "https://www.instagram.com/b.j.daniels/?hl=en",
            "http://www.facebook.com/KarenRoseBooks",
            "http://www.twitter.com/KarenRoseBooks",
            "http://www.instagram.com/karenrosebooks",
            "https://www.youtube.com/user/KarenRoseBooks",
            "https://www.facebook.com/DebraWebbAuthor/",
            "https://twitter.com/DebraWebbAuthor",
            "https://www.instagram.com/debraewebb/",
            "https://www.bookbub.com/authors/debra-webb",
            "https://www.goodreads.com/author/show/68900.Debra_Webb",
            "https://x.com/JenniferiRyan",
            "https://www.facebook.com/JenniferRyanBooks/",
            "https://www.instagram.com/jennifer_ryan_author/",
            "https://www.facebook.com/MCBeatonAuthor",
            "https://x.com/mc_beaton",
            "https://www.instagram.com/officialmcbeaton/",
            "https://www.youtube.com/@officialmcbeaton",
            "https://www.facebook.com/JoanneFlukeAuthor",
            "https://www.x.com/joannefluke",
            "https://www.youtube.com/channel/UCBjYVenN7x8yipAf7-6msvQ",
            "http://www.facebook.com/ellery.adams",
            "https://www.pinterest.com/elleryadams/",
            "https://www.instagram.com/elleryadams/",
            "https://www.facebook.com/KateCarlisleBooks/",
            "https://www.instagram.com/katecarlislebooks/",
            "https://www.goodreads.com/author/show/272650.Kate_Carlisle",
            "https://www.bookbub.com/profile/kate-carlisle",
            "https://www.pinterest.com/booksbykate/",
            "https://www.tiktok.com/@thekatecarlisle",
            "https://www.facebook.com/laurachildsauthor?fref=ts",
            "https://www.facebook.com/DonnaAndrewsBooks",
            "https://twitter.com/jk_rowling",
            "https://www.facebook.com/JKRowling",
            "https://www.facebook.com/rick.riordan.author",
            "https://twitter.com/rickriordan",
            "https://www.instagram.com/rickriordan/",
            "https://mastodon.ie/@rickriordan",
            "http://facebook.com/terrygoodkind",
            "http://www.twitter.com/terrygoodkind",
            "https://www.instagram.com/officialterrygoodkind",
            "http://www.vimeo.com/terrygoodkind",
            "http://www.youtube.com/user/terrygoodkind1",
            "https://www.reddit.com/user/RealTerryGoodkind/posts/",
            "https://www.facebook.com/pratchett/",
            "https://twitter.com/terryandrob",
            "http://cassandraclare.tumblr.com/",
            "http://twitter.com/cassieclare",
            "http://instagram.com/cassieclare1/",
            "http://facebook.com/cassandraclare",
            "https://www.pinterest.com/cassclare/",
            "https://www.instagram.com/paulabrackston/?hl=en",
            "https://www.facebook.com/worldofpaulabrackston",
            "https://www.pinterest.com/paulabrackston/",
            "https://www.youtube.com/c/PaulaBrackstonBooks",
            "https://www.facebook.com/lisakleypas",
            "https://www.instagram.com/lisakleypas/",
            "https://facebook.com/authorstephanielaurens",
            "https://www.facebook.com/AuthorHannahHowell/",
            "https://www.facebook.com/LorraineHeathBooks",
            "https://twitter.com/Lorraine_Heath",
            "http://www.instagram.com/LorraineHeathAuthor",
            "https://www.bookbub.com/authors/lorraine-heath",
            "https://www.facebook.com/AuthorJuliaQuinn/",
            "https://www.instagram.com/juliaquinnauthor/",
            "https://www.bookbub.com/profile/julia-quinn",
            "http://www.goodreads.com/author/show/63898.Julia_Quinn",
            "https://www.facebook.com/KarenChanceBooks/",
            "https://twitter.com/caspalmerseries",
            "https://www.instagram.com/karenchanceauthor/?fbclid=IwAR3Y6zEerHH-7h0DAZzauOXyo5w6C2s9oLqIjkj7CXRh2a6MVYD33g1yg4Y",
            "https://twitter.com/debbiemacomber",
            "https://www.facebook.com/DebbieMacomberWorld?ref=ts&fref=ts",
            "http://www.youtube.com/user/debbiemacombervideos?feature=watch",
            "https://instagram.com/debbiemacomber",
            "http://pinterest.com/macomberbooks/",
            "http://www.goodreads.com/author/show/11349.Debbie_Macomber",
            "https://www.bookbub.com/profile/debbie-macomber?list=author_books",
            "https://www.facebook.com/noraroberts",
            "https://www.instagram.com/norarobertsauthor/",
            "https://facebook.com/neal.asher",
            "https://twitter.com/nealasher",
            "https://twitter.com/lynne__graham",
            "https://www.facebook.com/lynne.graham3",
            "https://www.pinterest.com/lynnegraham/",
            "https://facebook.com/carolemortimerauthor",
            "https://twitter.com/carole_mortimer",
            "https://www.facebook.com/SusanMallery",
            "https://www.pinterest.com/susanmallery/",
            "https://www.goodreads.com/susanmallery",
            "https://instagram.com/susanmallery",
            "https://www.tiktok.com/@susanmallery",
            "https://www.bookbub.com/authors/susan-mallery",
            "https://facebook.com/janetdaileyauthor",
            "https://www.facebook.com/TheRealRobertCrais",
            "https://twitter.com/robertcrais",
            "https://instagram.com/robertcrais",
            "https://facebook.com/saraparetsky",
            "https://instagram.com/saraparetsky",
            "https://twitter.com/saraparetsky",
            "https://x.com/saraparetsky",
            "https://facebook.com/cormoranstrikenovelsofficial",
            "https://instagram.com/robertgalbraith",
            "https://twitter.com/rgalbraith",
            "https://x.com/rgalbraith",
            "https://facebook.com/authortaranmatharu",
            "https://instagram.com/taranmatharuauthor",
            "https://instagram.com/taranmatharuauthor/#",
            "https://twitter.com/taranmatharu1",
            "https://es-es.facebook.com/maria.duenas.oficial",
            "https://instagram.com/maria.duenas.oficial",
            "https://twitter.com/#!/mduenasoficial",
            "https://youtube.com/user/mariaduenasoficial",
            "https://facebook.com/escritorarosamontero",
            "https://twitter.com/@brunahusky",
            "https://www.facebook.com/sofia.rhei",
            "https://www.facebook.com/lauragallegooficial",
            "https://twitter.com/_LauraGallego",
            "https://www.instagram.com/lauragallegooficial/",
            "https://twitter.com/irenezoealameda",
            "https://youtube.com/user/irenezoealameda",
            "https://www.facebook.com/MeganMaxwellOficial",
            "https://twitter.com/MeganMaxwell",
            "https://instagram.com/megan__maxwell",
            "https://youtube.com/user/mismeganmaxwell",
            "https://linkedin.com/in/megan-maxwell-12209033",
            "https://facebook.com/partidofeministaespana",
            "https://instagram.com/partido_feminista_es",
            "https://tiktok.com/@partido_feminista_es",
            "https://twitter.com/p_feministaesp",
            "https://x.com/p_feministaesp",
            "https://youtube.com/@partidofeministaes",
            "https://es-la.facebook.com/mpdelasheras",
            "https://linkedin.com/in/monicaperezheras",
            "https://tiktok.com/@mpdelasheras",
            "https://twitter.com/mpdelasheras",
            "https://youtube.com/@escuelaeuropeadeoratoria"
        };

        StringBuilder html = new StringBuilder("<html><body>");
        for (String u : urls) {
            html.append("<a href='").append(u).append("'>link</a>");
        }
        html.append("</body></html>");

        String result = parser.extractSocialLinks(html.toString());
        Set<String> actual = new LinkedHashSet<>(Arrays.asList(result.split("◙")));

        Set<String> expected = Arrays.stream(urls)
                .map(u -> {
                    String htmlSingle = "<html><body><a href='" + u + "'>x</a></body></html>";
                    String canon = parser.extractSocialLinks(htmlSingle);
                    return canon.split("◙")[0];
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(actual, is(expected));
    }
}
