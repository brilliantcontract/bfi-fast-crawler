package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MessageFieldTest {

    @Test
    public void addsMessageWhenScrapeNinjaUsed() throws Exception {
        Path urls = Files.createTempFile("urls", ".txt");
        Files.write(urls, Collections.singletonList("https://example.com"));

        Downloader downloader = mock(Downloader.class);
        Parser parser = mock(Parser.class);
        ContactFormDetector detector = mock(ContactFormDetector.class);
        Storage storage = mock(Storage.class);

        String longPage = "<html><body>" + new String(new char[1500]).replace('\0', 'a') + "</body></html>";
        when(downloader.loadBaseUrl("https://example.com")).thenReturn(longPage);
        when(downloader.wasScrapeNinjaUsed()).thenReturn(true);
        when(parser.extractEmail(longPage)).thenReturn("");
        when(parser.extractPhone(longPage)).thenReturn("");
        when(parser.extractSocialLinks(longPage)).thenReturn("");
        when(parser.extractContactPageUrl(longPage, "https://example.com")).thenReturn("");

        Main main = new Main(urls, storage, downloader, parser, detector);
        Method m = Main.class.getDeclaredMethod("go");
        m.setAccessible(true);
        m.invoke(main);

        ArgumentCaptor<Website> captor = ArgumentCaptor.forClass(Website.class);
        verify(storage).append(captor.capture());
        Website site = captor.getValue();
        assertThat(site.getMessage(), is("Direct download failed; used ScrapeNinja"));
    }

    @Test
    public void addsMessageWhenPageLooksJsRendered() throws Exception {
        Path urls = Files.createTempFile("urls", ".txt");
        Files.write(urls, Collections.singletonList("https://example.com"));

        Downloader downloader = mock(Downloader.class);
        Parser parser = mock(Parser.class);
        ContactFormDetector detector = mock(ContactFormDetector.class);
        Storage storage = mock(Storage.class);

        String shortPage = "<html><body>short</body></html>";
        when(downloader.loadBaseUrl("https://example.com")).thenReturn(shortPage);
        when(downloader.wasScrapeNinjaUsed()).thenReturn(false);
        when(parser.extractEmail(shortPage)).thenReturn("");
        when(parser.extractPhone(shortPage)).thenReturn("");
        when(parser.extractSocialLinks(shortPage)).thenReturn("");
        when(parser.extractContactPageUrl(shortPage, "https://example.com")).thenReturn("");

        Main main = new Main(urls, storage, downloader, parser, detector);
        Method m = Main.class.getDeclaredMethod("go");
        m.setAccessible(true);
        m.invoke(main);

        ArgumentCaptor<Website> captor = ArgumentCaptor.forClass(Website.class);
        verify(storage).append(captor.capture());
        Website site = captor.getValue();
        assertThat(site.getMessage(), is("Website most likely rendered with JavaScript"));
    }
}

