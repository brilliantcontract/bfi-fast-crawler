package bc.bfi.crawler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MainContactPageFilterTest {

    @Test
    public void skipsUrlWithoutContactForm() throws Exception {
        Path urls = Files.createTempFile("urls", ".txt");
        Files.write(urls, java.util.Collections.singletonList("https://example.com"));

        Downloader downloader = mock(Downloader.class);
        Parser parser = mock(Parser.class);
        ContactFormDetector detector = mock(ContactFormDetector.class);
        Storage storage = mock(Storage.class);

        when(downloader.load("https://example.com")).thenReturn("home");
        when(parser.extractEmail("home")).thenReturn("");
        when(parser.extractPhone("home")).thenReturn("");
        when(parser.extractSocialLinks("home")).thenReturn("");
        when(parser.extractContactPageUrl("home", "https://example.com"))
                .thenReturn("https://example.com/contact");
        when(downloader.load("https://example.com/contact")).thenReturn("contact");
        when(detector.hasContactFormFromHtml("contact")).thenReturn(false);

        Main main = new Main(urls, storage, downloader, parser, detector);
        java.lang.reflect.Method m = Main.class.getDeclaredMethod("go");
        m.setAccessible(true);
        m.invoke(main);

        ArgumentCaptor<Website> captor = ArgumentCaptor.forClass(Website.class);
        verify(storage).append(captor.capture());
        Website site = captor.getValue();
        assertThat(site.getContactFormUrl(), is(""));
    }

    @Test
    public void savesUrlWithContactForm() throws Exception {
        Path urls = Files.createTempFile("urls", ".txt");
        Files.write(urls, java.util.Collections.singletonList("https://example.com"));

        Downloader downloader = mock(Downloader.class);
        Parser parser = mock(Parser.class);
        ContactFormDetector detector = mock(ContactFormDetector.class);
        Storage storage = mock(Storage.class);

        when(downloader.load("https://example.com")).thenReturn("home");
        when(parser.extractEmail("home")).thenReturn("");
        when(parser.extractPhone("home")).thenReturn("");
        when(parser.extractSocialLinks("home")).thenReturn("");
        when(parser.extractContactPageUrl("home", "https://example.com"))
                .thenReturn("https://example.com/contact");
        when(downloader.load("https://example.com/contact")).thenReturn("contact");
        when(detector.hasContactFormFromHtml("contact")).thenReturn(true);
        when(parser.extractEmail("contact")).thenReturn("e");
        when(parser.extractPhone("contact")).thenReturn("p");
        when(parser.extractSocialLinks("contact")).thenReturn("s");

        Main main = new Main(urls, storage, downloader, parser, detector);
        java.lang.reflect.Method m = Main.class.getDeclaredMethod("go");
        m.setAccessible(true);
        m.invoke(main);

        ArgumentCaptor<Website> captor = ArgumentCaptor.forClass(Website.class);
        verify(storage).append(captor.capture());
        Website site = captor.getValue();
        assertThat(site.getContactFormUrl(), is("https://example.com/contact"));
        assertThat(site.getEmails(), is("e"));
        assertThat(site.getPhones(), is("p"));
        assertThat(site.getSocialLinks(), is("s"));
    }
}
