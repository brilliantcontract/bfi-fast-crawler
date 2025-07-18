package bc.bfi.crawler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final Path DEFAULT_URLS_FILE = Paths.get("urls.txt");

    private final Path urlsFile;
    private final Storage storage;
    private final Downloader downloader;
    private final Parser parser;
    private final ContactFormDetector contactFormDetector;

    public Main() {
        this(DEFAULT_URLS_FILE, new Storage(), new Downloader(), new Parser(), null);
    }

    Main(Path urlsFile, Storage storage, Downloader downloader, Parser parser, ContactFormDetector detector) {
        this.urlsFile = urlsFile;
        this.storage = storage;
        this.downloader = downloader;
        this.parser = parser;
        this.contactFormDetector = detector != null ? detector : new ContactFormDetector(downloader);
    }

    public static void main(String[] args) throws IOException {
        new Main().go();
    }

    private void go() throws IOException {
        for (String url : Files.readAllLines(urlsFile)) {
            System.out.println("Scrape website: " + url);

            String page = downloader.loadBaseUrl(url);
            Website website = new Website(url);

            if (downloader.wasScrapeNinjaUsed()) {
                website.addMessage("Direct download failed; used ScrapeNinja");
            }

            String text = org.jsoup.Jsoup.parse(page).text().trim();
            if (text.length() < 1000) {
                website.addMessage("Website most likely rendered with JavaScript");
            }
            website.setEmails(parser.extractEmail(page));
            website.setPhones(parser.extractPhone(page));
            website.setSocialLinks(parser.extractSocialLinks(page));

            String contactUrl = parser.extractContactPageUrl(page, url);
            if (!contactUrl.isEmpty()) {
                String contactPage = downloader.load(contactUrl);
                if (downloader.wasScrapeNinjaUsed()) {
                    website.addMessage("Direct download failed; used ScrapeNinja");
                }
                boolean hasForm = contactFormDetector.hasContactFormFromHtml(contactPage);
                if (hasForm) {
                    website.setContactFormUrl(contactUrl);
                }
                if (website.getEmails().isEmpty()) {
                    website.setEmails(parser.extractEmail(contactPage));
                }
                if (website.getPhones().isEmpty()) {
                    website.setPhones(parser.extractPhone(contactPage));
                }
                if (website.getSocialLinks().isEmpty()) {
                    website.setSocialLinks(parser.extractSocialLinks(contactPage));
                }
            }

            website.print();
            System.out.println("------------------------------------");
            storage.append(website);
        }
    }

}
