package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class WebsiteAppendTest {

    @Test
    public void appendEmailsFiltersDuplicates() {
        Website site = new Website("example.com");
        site.setEmails("a@x.com");
        site.appendEmails("A@x.com◙b@x.com");
        assertThat(site.getEmails(), is("a@x.com◙b@x.com"));
    }

    @Test
    public void appendPhonesFiltersDuplicates() {
        Website site = new Website("example.com");
        site.setPhones("(260) 420-6945");
        site.appendPhones("260-420-6945");
        assertThat(site.getPhones(), is("(260) 420-6945"));
    }

    @Test
    public void appendSocialLinksFiltersDuplicates() {
        Website site = new Website("example.com");
        site.setSocialLinks("https://facebook.com/user");
        site.appendSocialLinks("https://FACEBOOK.com/user");
        assertThat(site.getSocialLinks(), is("https://facebook.com/user"));
    }
}
