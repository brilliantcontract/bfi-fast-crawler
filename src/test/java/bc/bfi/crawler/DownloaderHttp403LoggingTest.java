package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.Test;

public class DownloaderHttp403LoggingTest {

    @Test
    public void noStacktraceForHttp403() throws Exception {
        Logger logger = Logger.getLogger(Downloader.class.getName());
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        Downloader downloader = new Downloader();
        Method m = Downloader.class.getDeclaredMethod("logDownloadError", String.class, IOException.class);
        m.setAccessible(true);
        IOException ex = new IOException("Server returned HTTP response code: 403 for URL: https://example.com");
        m.invoke(downloader, "https://example.com", ex);

        LogRecord record = handler.last;
        assertThat(record.getThrown(), is(nullValue()));
        assertThat(record.getLevel(), is(Level.SEVERE));
        assertThat(record.getMessage(), containsString("403"));

        logger.removeHandler(handler);
    }

    @Test
    public void stacktraceForOtherErrors() throws Exception {
        Logger logger = Logger.getLogger(Downloader.class.getName());
        TestHandler handler = new TestHandler();
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        Downloader downloader = new Downloader();
        Method m = Downloader.class.getDeclaredMethod("logDownloadError", String.class, IOException.class);
        m.setAccessible(true);
        IOException ex = new IOException("Connection reset");
        m.invoke(downloader, "https://example.com", ex);

        LogRecord record = handler.last;
        assertThat(record.getThrown(), is((Throwable) ex));
        assertThat(record.getLevel(), is(Level.SEVERE));

        logger.removeHandler(handler);
    }

    private static class TestHandler extends Handler {
        LogRecord last;
        @Override
        public void publish(LogRecord record) { last = record; }
        @Override public void flush() {}
        @Override public void close() throws SecurityException {}
    }
}
