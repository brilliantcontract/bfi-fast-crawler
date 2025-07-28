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

public class DomainCountryInMainTest {

    @Test
    public void setsDomainCountryBasedOnUrl() throws Exception {
        Path urls = Files.createTempFile("urls", ".txt");
        Files.write(urls, Collections.singletonList("https://example.ua"));

        Downloader downloader = mock(Downloader.class);
        Parser parser = mock(Parser.class);
        ContactFormDetector detector = mock(ContactFormDetector.class);
        Storage storage = mock(Storage.class);

        when(downloader.loadBaseUrl("https://example.ua")).thenReturn("<html></html>");
        when(downloader.wasScrapeNinjaUsed()).thenReturn(false);
        when(parser.extractEmail(anyString())).thenReturn("");
        when(parser.extractPhone(anyString())).thenReturn("");
        when(parser.extractSocialLinks(anyString())).thenReturn("");
        when(parser.extractContactPageUrl(anyString(), eq("https://example.ua"))).thenReturn("");

        Main main = new Main(urls, storage, downloader, parser, detector);
        Method m = Main.class.getDeclaredMethod("go");
        m.setAccessible(true);
        m.invoke(main);

        ArgumentCaptor<Website> captor = ArgumentCaptor.forClass(Website.class);
        verify(storage).append(captor.capture());
        Website site = captor.getValue();
        assertThat(site.getDomainCountry(), is("Ukraine"));
    }
}
