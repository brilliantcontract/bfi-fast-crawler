package bc.bfi.crawler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ContactFormDetectorTest {

    @Test
    public void testDetectsSimpleContactForm() {
        String html = "<form action='/send'>" +
                "<input name='name'>" +
                "<input name='email'>" +
                "<textarea name='message'></textarea>" +
                "<input type='submit' value='Send'>" +
                "</form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(true));
    }

    @Test
    public void testIgnoresSearchForm() {
        String html = "<form action='/search'>" +
                "<input name='q'>" +
                "<button>search</button>" +
                "</form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(false));
    }

    @Test
    public void testIgnoresLoginForm() {
        String html = "<form>" +
                "<input name='login'>" +
                "<input type='password'>" +
                "<input type='submit'>" +
                "</form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(false));
    }

    @Test
    public void testMultipleFormsOneContact() {
        String html = "<form action='/search'><input name='q'></form>" +
                "<form action='/send'><input name='name'><input name='email'>" +
                "<textarea name='message'></textarea><button type='submit'>Send</button></form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(true));
    }

    @Test
    public void testDetectsNameWithHyphen() {
        String html = "<form>" +
                "<input name='name-*'>" +
                "<input name='email' type='email'>" +
                "<textarea placeholder='Message'></textarea>" +
                "<button type='submit'>Send</button>" +
                "</form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(true));
    }
}
