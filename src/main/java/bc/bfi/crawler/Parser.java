package bc.bfi.crawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;
import java.util.*;
import java.util.stream.Collectors;

class Parser {

    private final ContactPageParser contactPageParser = new ContactPageParser();
    private final EmailParser emailParser = new EmailParser();
    private final PhoneParser phoneParser = new PhoneParser();
    private final SocialLinksParser socialLinksParser = new SocialLinksParser();

    String extractContactPageUrl(String page, String url) {
        return contactPageParser.extractContactPage(page, url);
    }

    String extractEmail(String page) {
        return emailParser.extractEmails(page);
    }

    String extractPhone(String page) {
        return phoneParser.extractPhones(page);
    }

    String extractSocialLinks(String page) {
        return socialLinksParser.extractSocialLinks(page);
    }

    private class SocialLinksParser {

        private final Map<String, String> socialPatterns;

        private SocialLinksParser() {
            Map<String, String> map = new HashMap<>();
            map.put("FACEBOOK", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}facebook\\.com(?!/shares/|/sharer/|/sharer\\.php|/share\\.php|/l\\.php\\?u=|/rsrc\\.php/)[^\"']{2,80})");
            map.put("TIKTOK", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}tiktok\\.com[^\"']{2,80})");
            map.put("YOUTUBE", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}youtube\\.com[^\"']{2,80})");
            map.put("INSTAGRAM", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}instagram\\.com[^\"']{2,80})");
            map.put("TWITTER", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}twitter\\.com(?!/share)[^\"']{2,80})");
            map.put("LINKEDIN", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}linkedin\\.com(?!/shareArticle\\?|/cws/share)[^\"']{2,80})");
            map.put("PINTEREST", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}pinterest\\.com[^\"']{2,150})");

            this.socialPatterns = Collections.unmodifiableMap(map);
        }

        String extractSocialLinks(String html) {
            Set<String> allLinks = new LinkedHashSet<>();
            for (String patternStr : socialPatterns.values()) {
                Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    String url = matcher.group("value");
                    allLinks.add(unifyUrlOfSocialNetwork(url));
                }
            }
            return allLinks.stream().collect(Collectors.joining("◙"));
        }

        /**
         * Basic normalization: trim, remove trailing slashes, lowercase
         * scheme/domain if needed. Can be expanded for specific networks.
         */
        private String unifyUrlOfSocialNetwork(String url) {
            if (url == null) {
                return "";
            }
            url = url.trim();
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }
            return url;
        }
    }

    private class PhoneParser {

        private static final String phoneRegex
                = "((?<=[\\W])|^)(?<value>(\\(?\\d{3}\\)?[. -])?\\d{3}[. -]\\d{4}|\\+?\\d{1,3}[. -]\\d{3}[. -]\\d{3}[. -]\\d{4})((?=[\\W])|$)";
        private final Pattern pattern;

        PhoneParser() {
            pattern = Pattern.compile(phoneRegex);
        }

        String extractPhones(String pageContent) {
            List<String> phoneNumbers = new ArrayList<>();
            Matcher matcher = pattern.matcher(pageContent);

            while (matcher.find()) {
                String phone = matcher.group("value");
                phoneNumbers.add(phone);
            }

            // Filter out likely false positives
            phoneNumbers = phoneNumbers.stream()
                    .filter(phoneNumber -> !phoneNumber.matches("^([\\s.\\-]?(19|20)?\\d{2}[\\s.\\-]\\d{2}[\\s.\\-]?|\\d{3}[\\s.\\-]\\d{3}|(0|1|2|3)\\d{1}[\\s.\\-](0|1|2|3)\\d{1}[\\s.\\-](21|20|19|18|17)\\d{2}|\\d{4}[\\s.\\-]\\d{4}|\\d{5}[\\s.\\-]\\d{5})$"))
                    .collect(Collectors.toList());

            removeShortestPhoneNumbers(phoneNumbers);

            // Remove duplicate numbers while keeping the original order
            phoneNumbers = new ArrayList<>(new LinkedHashSet<>(phoneNumbers));

            return phoneNumbers.stream().collect(Collectors.joining("◙"));
        }

        private void removeShortestPhoneNumbers(List<String> phoneNumbers) {
            if (phoneNumbers.size() <= 1) {
                return;
            }

            int minLen = phoneNumbers.stream().mapToInt(String::length).min().orElse(0);
            phoneNumbers.removeIf(p -> p.length() == minLen);
        }
    }

    private class EmailParser {

        private static final String emailRegex
                = "(\\b|^)(?<value>[A-Za-z0-9\\-_]+[A-Za-z0-9\\-_.]*@[A-Za-z0-9.:\\-]+\\.[A-Za-z]{2,12})(\\b|$)";
        private final Pattern pattern;

        EmailParser() {
            pattern = Pattern.compile(emailRegex);
        }

        String extractEmails(String pageContent) {
            // Use a set to automatically remove duplicates while preserving
            // the order of discovery so test expectations remain stable.
            Set<String> emails = new LinkedHashSet<>();
            Matcher matcher = pattern.matcher(pageContent);
            while (matcher.find()) {
                String email = matcher.group("value");
                emails.add(email);
            }

            return emails.stream().collect(Collectors.joining("◙"));
        }
    }

    private class ContactPageParser {

        private final List<String> contactsPage = new ArrayList<>();

        public ContactPageParser() {
            initializeListsWithWords();
        }

        private void initializeListsWithWords() {
            contactsPage.addAll(Arrays.asList(
                    "GET IN TOUCH", "REACH OUT", "CONNECT", "CONTACT US", "CONTACT ME", "CONTACT INFO", "CONTACT SUPPORT",
                    "CUSTOMER SUPPORT", "HELP & SUPPORT", "REQUEST INFO", "SUBMIT AN INQUIRY", "INQUIRY", "FEEDBACK",
                    "SEND A MESSAGE", "SAY HELLO", "DROP US A LINE", "LET’S CHAT", "HIT US UP", "TALK TO US",
                    "START A CONVERSATION", "PING US", "MESSAGE US", "HOLLER AT US", "REQUEST A CONSULTATION",
                    "BOOK A CALL", "SCHEDULE A MEETING", "REQUEST SUPPORT", "CLIENT SERVICES", "BUSINESS INQUIRIES",
                    "CONNECT WITH SALES", "PARTNER WITH US", "WORK WITH US"
            ));
        }

        public String extractContactPage(final String html, final String url) {
            Pattern linkPattern = Pattern.compile(
                    "<a\\s+[^>]*href=['\"](?<href>[^'\"]+)['\"][^>]*>(?<text>.*?)</a>",
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL
            );

            Matcher matcher = linkPattern.matcher(html);
            List<String> candidateLinks = new ArrayList<>();

            while (matcher.find()) {
                String href = matcher.group("href").trim();
                String text = matcher.group("text").replaceAll("\\s+", " ").toUpperCase(Locale.ENGLISH).trim();

                // Match by link text
                for (String keyword : contactsPage) {
                    if (text.contains(keyword)) {
                        candidateLinks.add(href);
                    }
                }

                // Match by URL pattern
                if (href.matches(".*(contact|contacts|contact-us|contact_us)[^\\s\"'>]*")) {
                    candidateLinks.add(href);
                }
            }

            if (candidateLinks.isEmpty()) {
                return "";
            }

            String contactPageUrl = candidateLinks.get(0);
            contactPageUrl = appendHostname(contactPageUrl, url);
            return contactPageUrl;
        }

        private String appendHostname(String contactPageUrl, String url) {
            if (!contactPageUrl.toUpperCase().startsWith("HTTP")) {
                contactPageUrl = Utils.extractBaseUrl(url) + contactPageUrl;
            }

            return contactPageUrl;
        }

    }

}
