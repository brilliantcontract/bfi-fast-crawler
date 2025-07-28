package bc.bfi.crawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

class Website {

    private final String domain;
    private String emails = "";
    private String phones = "";
    private String contactFormUrl = "";
    private String socialLinks = "";
    private String message = "";

    public Website(String domain) {
        this.domain = domain;
    }

    String getEmails() {
        return emails;
    }

    void setEmails(String emails) {
        this.emails = emails;
    }

    void appendEmails(String emails) {
        this.emails = append(this.emails, emails, true);
    }

    String getPhones() {
        return phones;
    }

    void setPhones(String phones) {
        this.phones = phones;
    }

    void appendPhones(String phones) {
        this.phones = append(this.phones, phones, false);
    }

    String getContactFormUrl() {
        return contactFormUrl;
    }

    void setContactFormUrl(String contactFormUrl) {
        this.contactFormUrl = contactFormUrl;
    }

    String getSocialLinks() {
        return socialLinks;
    }

    void setSocialLinks(String socialLinks) {
        this.socialLinks = socialLinks;
    }

    void appendSocialLinks(String links) {
        this.socialLinks = append(this.socialLinks, links, true);
    }

    private String append(String original, String extra, boolean ignoreCase) {
        if (extra == null || extra.isEmpty()) {
            return original;
        }
        Map<String, String> canonical = new LinkedHashMap<>();
        if (original != null && !original.isEmpty()) {
            for (String part : original.split("◙")) {
                if (part.isEmpty()) {
                    continue;
                }
                canonical.put(normalize(part, ignoreCase), part);
            }
        }
        for (String part : extra.split("◙")) {
            if (part.isEmpty()) {
                continue;
            }
            String key = normalize(part, ignoreCase);
            if (!canonical.containsKey(key)) {
                canonical.put(key, part);
            }
        }
        return String.join("◙", canonical.values());
    }

    private String normalize(String value, boolean ignoreCase) {
        if (!ignoreCase) {
            String digits = value.replaceAll("\\D", "");
            if (digits.length() == 11 && digits.startsWith("1")) {
                digits = digits.substring(1);
            }
            return digits;
        }
        return value.toLowerCase();
    }

    String getDomain() {
        return domain;
    }

    String getMessage() {
        return message;
    }

    void addMessage(String msg) {
        if (msg == null || msg.isEmpty()) {
            return;
        }
        if (message.isEmpty()) {
            message = msg;
        } else if (!message.contains(msg)) {
            message += "; " + msg;
        }
    }

    void print() {
        System.out.println("Domain: " + this.domain);
        System.out.println("Contact form: " + this.contactFormUrl);
        System.out.println("E-mails: " + this.emails);
        System.out.println("Phones: " + this.phones);
        System.out.println("Social links: " + this.socialLinks);
        System.out.println("Message: " + this.message);
    }

}
