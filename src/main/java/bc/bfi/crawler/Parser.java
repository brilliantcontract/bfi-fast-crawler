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
            map.put("FACEBOOK", "href=['\"]?(?<value>https?[\\w\\.:/-]{3,40}(?:facebook\\.com|fb\\.com|fb\\.me)(?!/shares/|/sharer/|/sharer\\.php|/share\\.php|/l\\.php\\?u=|/rsrc\\.php/)[^\"']{1,80})");
            map.put("TIKTOK", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}tiktok\\.com[^\"']{2,80})");
            map.put("YOUTUBE", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}youtube\\.com[^\"']{2,80})");
            map.put("INSTAGRAM", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}instagram\\.com[^\"']{2,80})");
            map.put("TWITTER", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}(?:twitter\\.com|x\\.com)(?!/share)[^\"']{2,80})");
            map.put("LINKEDIN", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}linkedin\\.com(?!/shareArticle\\?|/cws/share)[^\"']{2,80})");
            map.put("PINTEREST", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}pinterest\\.com[^\"']{2,150})");
            map.put("REDDIT", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}(?:reddit\\.com|redd\\.it)[^\"']{2,80})");
            map.put("SNAPCHAT", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}snapchat\\.com[^\"']{2,80})");
            map.put("SOUNDCLOUD", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}soundcloud\\.com[^\"']{2,80})");
            map.put("VIMEO", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}vimeo\\.com[^\"']{2,80})");
            map.put("THREADS", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}threads\\.net[^\"']{2,80})");
            map.put("BOOKBUB", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}bookbub\\.com[^\"']{2,80})");
            map.put("GOODREADS", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}goodreads\\.com[^\"']{2,80})");
            map.put("MASTODON", "href=['\"]?(?<value>https?[\\w\\.:/]{3,11}[\\w.-]*mastodon\\.[^\"']{2,80})");
            map.put("TUMBLR", "href=['\"]?(?<value>https?[\\w\\.:/-]{3,40}[\\w.-]*tumblr\\.com[^\"']{0,80})");

            this.socialPatterns = Collections.unmodifiableMap(map);
        }

        String extractSocialLinks(String html) {
            Map<String, String> canonical = new LinkedHashMap<>();
            for (String patternStr : socialPatterns.values()) {
                Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(html);
                while (matcher.find()) {
                    String url = matcher.group("value");
                    String normalized = unifyUrlOfSocialNetwork(url);
                    if (!isProfileUrl(normalized)) {
                        continue;
                    }
                    String key = buildCanonicalKey(normalized);
                    String existing = canonical.get(key);
                    if (existing == null) {
                        canonical.put(key, normalized);
                    } else {
                        canonical.put(key, choosePreferred(existing, normalized));
                    }
                }
            }
            return canonical.values().stream().collect(Collectors.joining("◙"));
        }

        private String buildCanonicalKey(String url) {
            String key = url.toLowerCase();
            key = key.replaceFirst("^https?://", "");
            key = key.replaceFirst("^www\\.", "");
            key = key.replaceFirst("^m\\.", "");
            return key;
        }

        private String choosePreferred(String a, String b) {
            if (a.equals(b)) {
                return a;
            }
            // Prefer www.facebook.com variant
            if (a.contains("facebook.com") && b.contains("facebook.com")) {
                if (a.contains("www.facebook.com")) {
                    return a;
                }
                if (b.contains("www.facebook.com")) {
                    return b;
                }
            }
            // Prefer https and www for twitter/x
            if ((a.contains("twitter.com") || a.contains("x.com"))
                    && (b.contains("twitter.com") || b.contains("x.com"))) {
                String aw = a.replaceFirst("^http://", "https://");
                if (!aw.contains("www.")) {
                    aw = aw.replaceFirst("://", "://www.");
                }
                String bw = b.replaceFirst("^http://", "https://");
                if (!bw.contains("www.")) {
                    bw = bw.replaceFirst("://", "://www.");
                }
                return aw.compareTo(bw) <= 0 ? aw : bw;
            }
            // Otherwise keep the first
            return a;
        }

        private boolean isProfileUrl(String url) {
            String lower = url.toLowerCase(Locale.ENGLISH);
            if (lower.contains("facebook.com")) {
                if (lower.matches("https?://www\\.facebook\\.com/(?:groups|events)/.*")) {
                    return false;
                }
            }
            if (lower.contains("twitter.com") || lower.contains("x.com")) {
                if (lower.matches("https?://www\\.(?:twitter\\.com|x\\.com)/[^/]+/status/.*")) {
                    return false;
                }
                if (lower.matches("https?://www\\.(?:twitter\\.com|x\\.com)/(?:share|intent|search|home)/.*")) {
                    return false;
                }
            }
            if (lower.contains("instagram.com")) {
                if (lower.matches("https?://www\\.instagram\\.com/(?:p|reel|tv)/.*")) {
                    return false;
                }
            }
            if (lower.contains("pinterest.com")) {
                if (lower.matches("https?://www\\.pinterest\\.com/(?:pin|explore|search)/.*")) {
                    return false;
                }
            }
            return true;
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
            if (url.matches("(?i)https?://(?:www\\.)?(?:twitter\\.com|x\\.com)/#!/.*")) {
                url = url.replace("#!/", "/");
            }
            if (url.matches("(?i)https?://(?:www\\.)?(?:twitter\\.com|x\\.com)/@.*")) {
                url = url.replaceFirst("/@", "/");
            }
            url = url.replaceFirst("(?i)://((?:www\\.)?(?:twitter\\.com|x\\.com))//", "://$1/");
            if (!url.toLowerCase().startsWith("http")) {
                url = "https://" + url;
            }

            try {
                URL parsed = new URL(url);
                String host = parsed.getHost();
                if (!host.toLowerCase(Locale.ENGLISH).startsWith("www.")) {
                    host = "www." + host;
                }
                String path = parsed.getPath();
                String query = parsed.getQuery();
                String fragment = parsed.getRef();
                StringBuilder sb = new StringBuilder();
                sb.append("https://").append(host);
                if (path != null && !path.isEmpty()) {
                    sb.append(path);
                }
                if (query != null && !query.isEmpty()) {
                    sb.append('?').append(query);
                }
                if (fragment != null && !fragment.isEmpty()) {
                    sb.append('#').append(fragment);
                }
                url = sb.toString();
            } catch (MalformedURLException ex) {
                url = url.replaceFirst("^http://", "https://");
            }

            // Remove trailing slash if present
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }

            if (url.endsWith("#")) {
                url = url.substring(0, url.length() - 1);
            }

            // Ensure leading www. for consistency across networks
            url = url.replaceFirst("(?i)://(?!www\\.)", "://www.");

            // Normalize alternative Facebook and Reddit domains
            url = url.replaceFirst("(?i)://(?:[\\w.-]*\\.)?fb\\.com", "://www.facebook.com");
            url = url.replaceFirst("(?i)://(?:[\\w.-]*\\.)?fb\\.me", "://www.facebook.com");
            url = url.replaceFirst("(?i)://(?:[\\w.-]*\\.)?facebook\\.com", "://www.facebook.com");
            url = url.replaceFirst("(?i)://(?:www\\.)*redd\\.it", "://www.reddit.com");
            url = url.replaceFirst("(?i)://(?:old\\.|www\\.)*reddit\\.com", "://www.reddit.com");
            url = url.replaceFirst("(?i)://(?:www\\.)?reddit\\.com/u/([^/?#]+)", "://www.reddit.com/user/$1");
            url = url.replaceFirst("(?i)://(?:www\\.)?reddit\\.com/([^/?#]+)$", "://www.reddit.com/user/$1");

            return url;
        }
    }

    private class PhoneParser {

        private static final String phoneRegex
                = "(?<!\\d)(?<value>(?:\\+?1[\\s.-]*)?\\(?\\d{3}\\)?[\\s.-]*\\d{3}[\\s.-]*\\d{4}|\\d{10,11}|\\d{2}-\\d{7})(?!\\d)";
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
            int maxLen = phoneNumbers.stream().mapToInt(String::length).max().orElse(0);
            if (minLen == maxLen) {
                return;
            }
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
            if (pageContent == null) {
                return "";
            }

            // Normalize common malformed mailto links and remove the scheme
            pageContent = pageContent.replace("mailto:%20", "");
            pageContent = pageContent.replaceAll("(?i)mailto:", "");

            // Deduplicate emails while comparing by a canonical form that
            // strips leading "20" which often appears from encoded spaces in
            // mailto links.
            Map<String, String> canonicalToOriginal = new LinkedHashMap<>();
            Matcher matcher = pattern.matcher(pageContent);
            while (matcher.find()) {
                String email = matcher.group("value");
                String canonical = email.replaceFirst("^20(?=[A-Za-z0-9])", "");
                String lower = canonical.toLowerCase(Locale.ENGLISH);
                if (lower.matches(".*@[0-9]+x\\.(png|jpe?g|gif|bmp|svg|webp)$")) {
                    continue;
                }
                canonicalToOriginal.put(lower, email);
            }

            return canonicalToOriginal.values().stream()
                    .collect(Collectors.joining("◙"));
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
            return normalizeContactUrl(contactPageUrl);
        }

        private String appendHostname(String contactPageUrl, String url) {
            if (!contactPageUrl.toUpperCase().startsWith("HTTP")) {
                contactPageUrl = Utils.extractBaseUrl(url) + contactPageUrl;
            }

            return contactPageUrl;
        }

        private String normalizeContactUrl(String contactPageUrl) {
            if (contactPageUrl == null) {
                return "";
            }

            contactPageUrl = contactPageUrl.trim();
            // Remove a trailing slash both at the end of the URL and
            // directly before a query or fragment part.
            contactPageUrl = contactPageUrl.replaceFirst("/(?=[?#]|$)", "");
            return contactPageUrl;
        }

    }

}
