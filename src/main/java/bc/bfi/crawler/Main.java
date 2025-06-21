package bc.bfi.crawler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private final static Path URLS_FILE = Paths.get("urls.txt");

    private final Storage storage = new Storage();
    private final Downloader downloader = new Downloader();
    private final Parser parser = new Parser();

    public static void main(String[] args) throws IOException {
        new Main().go();
    }

    private void go() throws IOException {
        for (String url : Files.readAllLines(URLS_FILE)) {
            System.out.println("Scrape website: " + url);

            String page = downloader.load(url);

            Website website = new Website(url);
            website.setContactFormUrl(parser.extractContactPageUrl(page, url));
            website.setEmails(parser.extractEmail(page));
            website.setPhones(parser.extractPhone(page));
            website.setSocialLinks(parser.extractSocialLinks(page));

            if (!website.getContactFormUrl().isEmpty()) {
                if (website.getEmails().isEmpty()) {
                    website.setEmails(parser.extractEmail(page));
                }
                if (website.getPhones().isEmpty()) {
                    website.setPhones(parser.extractPhone(page));
                }
                if (website.getSocialLinks().isEmpty()) {
                    website.setSocialLinks(parser.extractSocialLinks(page));
                }
            }

            website.print();
            System.out.println("------------------------------------");
            storage.append(website);
        }
    }

}
