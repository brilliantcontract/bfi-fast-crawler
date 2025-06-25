package bc.bfi.crawler;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ContactFormDetector {
    private static final Logger LOG = Logger.getLogger(ContactFormDetector.class.getName());

    private final Downloader downloader;

    ContactFormDetector() {
        this(new Downloader());
    }

    ContactFormDetector(Downloader downloader) {
        this.downloader = downloader;
    }

    boolean hasContactFormFromHtml(String html) {
        try {
            Document doc = Jsoup.parse(html);
            return detect(doc);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Failed to parse html", ex);
            return false;
        }
    }

    private boolean detect(Document doc) {
        Elements forms = doc.select("form");
        for (Element form : forms) {
            if (isContactForm(form)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContactForm(Element form) {
        if (isSearchForm(form) || isSignInForm(form) || isSignUpForm(form)
                || isDonateForm(form) || isSubscriptionForm(form)) {
            return false;
        }
        int score = 0;
        if (hasNameField(form)) score++;
        if (hasEmailField(form)) score++;
        if (hasMessageField(form)) score++;
        if (hasSubmitButton(form)) score++;
        return score >= 3;
    }

    private boolean hasNameField(Element form) {
        return !form.select("input[name~=(?i)name], input[id~=(?i)name], input[class~=(?i)name], input[placeholder~=(?i)name], label:matchesOwn((?i)name)").isEmpty();
    }

    private boolean hasEmailField(Element form) {
        return !form.select("input[type=email], input[name~=(?i)mail], input[id~=(?i)mail], input[class~=(?i)mail], input[placeholder~=(?i)mail]").isEmpty();
    }

    private boolean hasMessageField(Element form) {
        return !form.select("textarea, input[name~=(?i)message], input[placeholder~=(?i)message], input[id~=(?i)message]").isEmpty();
    }

    private boolean hasSubmitButton(Element form) {
        return !form.select("input[type=submit], button[type=submit], button:matchesOwn((?i)send|submit), input[value~=(?i)send)").isEmpty();
    }

    private boolean isSearchForm(Element form) {
        if (form.attr("action").toLowerCase().contains("search")) return true;
        return !form.select("input[type=search], input[name~=(?i)search], input[id~=(?i)search], button:matchesOwn((?i)search)").isEmpty();
    }

    private boolean isDonateForm(Element form) {
        if (form.attr("action").toLowerCase().contains("donat")) return true;
        return !form.select("input[name~=(?i)donat], input[id~=(?i)donat], button:matchesOwn((?i)donat)").isEmpty();
    }

    private boolean isSubscriptionForm(Element form) {
        if (form.attr("action").toLowerCase().contains("subscri")) return true;
        return !form.select("input[name~=(?i)subscri], button:matchesOwn((?i)subscri)").isEmpty();
    }

    private boolean isSignInForm(Element form) {
        boolean hasPassword = !form.select("input[type=password]").isEmpty();
        boolean hasLogin = !form.select("input[name~=(?i)login|sign.?in], button:matchesOwn((?i)log.?in|sign.?in)").isEmpty();
        return hasPassword && hasLogin;
    }

    private boolean isSignUpForm(Element form) {
        boolean hasPassword = !form.select("input[type=password]").isEmpty();
        boolean hasSignup = !form.select("input[name~=(?i)sign.?up|register], button:matchesOwn((?i)sign.?up|register)").isEmpty();
        return hasPassword && hasSignup;
    }
}
