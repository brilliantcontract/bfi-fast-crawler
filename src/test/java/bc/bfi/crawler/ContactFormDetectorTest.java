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
    @Test
    public void testDetectsWpCf7ContactForm() {
        String html = "<form action='/contact-debra/#wpcf7-f3091-p80-o1' method='post' class='wpcf7-form init' novalidate='novalidate'>" +
                "<div style='display: none;'><input type='hidden' name='_wpcf7' value='3091' />" +
                "<input type='hidden' name='_wpcf7_version' value='6.0.5' />" +
                "<input type='hidden' name='_wpcf7_locale' value='en_US' />" +
                "<input type='hidden' name='_wpcf7_unit_tag' value='wpcf7-f3091-p80-o1' />" +
                "<input type='hidden' name='_wpcf7_container_post' value='80' />" +
                "</div>" +
                "<p><span class='wpcf7-form-control-wrap' data-name='your-name'><input type='text' name='your-name'></span></p>" +
                "<p><span class='wpcf7-form-control-wrap' data-name='your-email'><input type='email' name='your-email'></span></p>" +
                "<p><span class='wpcf7-form-control-wrap' data-name='your-message'><textarea name='your-message'></textarea></span></p>" +
                "<p><input type='submit' value='Submit' class='wpcf7-form-control wpcf7-submit'></p>" +
                "</form>";
        ContactFormDetector detector = new ContactFormDetector();
        assertThat(detector.hasContactFormFromHtml(html), is(true));
    }
}
