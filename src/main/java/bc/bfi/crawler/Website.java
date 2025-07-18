package bc.bfi.crawler;

import java.net.MalformedURLException;
import java.net.URL;

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

    String getPhones() {
        return phones;
    }

    void setPhones(String phones) {
        this.phones = phones;
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
