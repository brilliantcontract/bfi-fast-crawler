package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class DomainCountryTest {

    @Test
    public void detectsCountryFromUrl() {
        assertThat(Utils.getDomainCountry("https://example.ua"), is("Ukraine"));
        assertThat(Utils.getDomainCountry("example.ru"), is("Russia"));
        assertThat(Utils.getDomainCountry("example.com"), is(""));
        assertThat(Utils.getDomainCountry("https://foo.bar.net/path"), is(""));
    }
}
