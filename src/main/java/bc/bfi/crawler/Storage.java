package bc.bfi.crawler;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

class Storage {

    private static final String STORAGE_FILE = "websites.csv";
    private static final Logger LOGGER = Logger.getLogger(Storage.class.getName());

    private static final String[] HEADERS = {
        "DOMAIN",
        "EMAILS",
        "PHONES",
        "CONTACT_FORM_URL",
        "SOCIAL_LINKS",
        "MESSAGE"
    };

    Storage() {
        if (!Files.exists(Paths.get("STORAGE_FILE"))) {
            try {
                createCsvFile();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Cannot write to .csv file. " + ex.getMessage(), ex);
                System.exit(1);
            }
        }
    }

    private void createCsvFile() {
        Path path = Paths.get(STORAGE_FILE);
        if (Files.exists(path)) {
            System.err.println(".csv file already exist: " + path);
            System.exit(1);
        }

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            CSVFormat format = CSVFormat.DEFAULT.withIgnoreHeaderCase();
            try (CSVPrinter printer = new CSVPrinter(writer, format)) {
                printer.printRecord((Object[]) HEADERS);
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Cannot create .csv file", ex);
            System.exit(1);
        }
    }

    void append(Website website) {
        List<String> record = new ArrayList<>();
        record.add(website.getDomain());
        record.add(website.getEmails());
        record.add(website.getPhones());
        record.add(website.getContactFormUrl());
        record.add(website.getSocialLinks());
        record.add(website.getMessage());

        Path path = Paths.get(STORAGE_FILE);
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            CSVFormat format = CSVFormat.DEFAULT;
            try (CSVPrinter printer = new CSVPrinter(writer, format)) {
                printer.printRecord(record);
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Cannot write to .csv file. " + ex.getMessage(), ex);
            System.exit(1);
        }
    }

    void append(final List<Website> websites) {
        for (Website website : websites) {
            append(website);
        }
    }
}
