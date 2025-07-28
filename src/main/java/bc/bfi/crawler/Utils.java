package bc.bfi.crawler;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Utils {

    private static final Map<String, String> COUNTRY_MAP;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("af", "Afghanistan");
        map.put("ax", "\u00C5land Islands");
        map.put("al", "Albania");
        map.put("dz", "Algeria");
        map.put("as", "American Samoa");
        map.put("ad", "Andorra");
        map.put("ao", "Angola");
        map.put("ai", "Anguilla");
        map.put("aq", "Antarctica");
        map.put("ag", "Antigua and Barbuda");
        map.put("ar", "Argentina");
        map.put("am", "Armenia");
        map.put("aw", "Aruba");
        map.put("au", "Australia");
        map.put("at", "Austria");
        map.put("az", "Azerbaijan");
        map.put("bs", "Bahamas");
        map.put("bh", "Bahrain");
        map.put("bd", "Bangladesh");
        map.put("bb", "Barbados");
        map.put("by", "Belarus");
        map.put("be", "Belgium");
        map.put("bz", "Belize");
        map.put("bj", "Benin");
        map.put("bm", "Bermuda");
        map.put("bt", "Bhutan");
        map.put("bo", "Bolivia, Plurinational State of");
        map.put("bq", "Bonaire, Sint Eustatius and Saba");
        map.put("ba", "Bosnia and Herzegovina");
        map.put("bw", "Botswana");
        map.put("bv", "Bouvet Island");
        map.put("br", "Brazil");
        map.put("io", "British Indian Ocean Territory");
        map.put("bn", "Brunei Darussalam");
        map.put("bg", "Bulgaria");
        map.put("bf", "Burkina Faso");
        map.put("bi", "Burundi");
        map.put("kh", "Cambodia");
        map.put("cm", "Cameroon");
        map.put("ca", "Canada");
        map.put("cv", "Cape Verde");
        map.put("ky", "Cayman Islands");
        map.put("cf", "Central African Republic");
        map.put("td", "Chad");
        map.put("cl", "Chile");
        map.put("cn", "China");
        map.put("cx", "Christmas Island");
        map.put("cc", "Cocos (Keeling) Islands");
        map.put("co", "Colombia");
        map.put("km", "Comoros");
        map.put("cg", "Congo");
        map.put("cd", "Congo, the Democratic Republic of the");
        map.put("ck", "Cook Islands");
        map.put("cr", "Costa Rica");
        map.put("ci", "C\u00F4te d'Ivoire");
        map.put("hr", "Croatia");
        map.put("cu", "Cuba");
        map.put("cw", "Cura\u00E7ao");
        map.put("cy", "Cyprus");
        map.put("cz", "Czech Republic");
        map.put("dk", "Denmark");
        map.put("dj", "Djibouti");
        map.put("dm", "Dominica");
        map.put("do", "Dominican Republic");
        map.put("ec", "Ecuador");
        map.put("eg", "Egypt");
        map.put("sv", "El Salvador");
        map.put("gq", "Equatorial Guinea");
        map.put("er", "Eritrea");
        map.put("ee", "Estonia");
        map.put("et", "Ethiopia");
        map.put("fk", "Falkland Islands (Malvinas)");
        map.put("fo", "Faroe Islands");
        map.put("fj", "Fiji");
        map.put("fi", "Finland");
        map.put("fr", "France");
        map.put("gf", "French Guiana");
        map.put("pf", "French Polynesia");
        map.put("tf", "French Southern Territories");
        map.put("ga", "Gabon");
        map.put("gm", "Gambia");
        map.put("ge", "Georgia");
        map.put("de", "Germany");
        map.put("gh", "Ghana");
        map.put("gi", "Gibraltar");
        map.put("gr", "Greece");
        map.put("gl", "Greenland");
        map.put("gd", "Grenada");
        map.put("gp", "Guadeloupe");
        map.put("gu", "Guam");
        map.put("gt", "Guatemala");
        map.put("gg", "Guernsey");
        map.put("gn", "Guinea");
        map.put("gw", "Guinea-Bissau");
        map.put("gy", "Guyana");
        map.put("ht", "Haiti");
        map.put("hm", "Heard Island and McDonald Islands");
        map.put("va", "Holy See (Vatican City State)");
        map.put("hn", "Honduras");
        map.put("hk", "Hong Kong");
        map.put("hu", "Hungary");
        map.put("is", "Iceland");
        map.put("in", "India");
        map.put("id", "Indonesia");
        map.put("ir", "Iran, Islamic Republic of");
        map.put("iq", "Iraq");
        map.put("ie", "Ireland");
        map.put("im", "Isle of Man");
        map.put("il", "Israel");
        map.put("it", "Italy");
        map.put("jm", "Jamaica");
        map.put("jp", "Japan");
        map.put("je", "Jersey");
        map.put("jo", "Jordan");
        map.put("kz", "Kazakhstan");
        map.put("ke", "Kenya");
        map.put("ki", "Kiribati");
        map.put("kp", "Korea, Democratic People's Republic of");
        map.put("kr", "Korea, Republic of");
        map.put("kw", "Kuwait");
        map.put("kg", "Kyrgyzstan");
        map.put("la", "Lao People's Democratic Republic");
        map.put("lv", "Latvia");
        map.put("lb", "Lebanon");
        map.put("ls", "Lesotho");
        map.put("lr", "Liberia");
        map.put("ly", "Libya");
        map.put("li", "Liechtenstein");
        map.put("lt", "Lithuania");
        map.put("lu", "Luxembourg");
        map.put("mo", "Macao");
        map.put("mk", "Macedonia, the Former Yugoslav Republic of");
        map.put("mg", "Madagascar");
        map.put("mw", "Malawi");
        map.put("my", "Malaysia");
        map.put("mv", "Maldives");
        map.put("ml", "Mali");
        map.put("mt", "Malta");
        map.put("mh", "Marshall Islands");
        map.put("mq", "Martinique");
        map.put("mr", "Mauritania");
        map.put("mu", "Mauritius");
        map.put("yt", "Mayotte");
        map.put("mx", "Mexico");
        map.put("fm", "Micronesia, Federated States of");
        map.put("md", "Moldova, Republic of");
        map.put("mc", "Monaco");
        map.put("mn", "Mongolia");
        map.put("me", "Montenegro");
        map.put("ms", "Montserrat");
        map.put("ma", "Morocco");
        map.put("mz", "Mozambique");
        map.put("mm", "Myanmar");
        map.put("na", "Namibia");
        map.put("nr", "Nauru");
        map.put("np", "Nepal");
        map.put("nl", "Netherlands");
        map.put("nc", "New Caledonia");
        map.put("nz", "New Zealand");
        map.put("ni", "Nicaragua");
        map.put("ne", "Niger");
        map.put("ng", "Nigeria");
        map.put("nu", "Niue");
        map.put("nf", "Norfolk Island");
        map.put("mp", "Northern Mariana Islands");
        map.put("no", "Norway");
        map.put("om", "Oman");
        map.put("pk", "Pakistan");
        map.put("pw", "Palau");
        map.put("ps", "Palestine, State of");
        map.put("pa", "Panama");
        map.put("pg", "Papua New Guinea");
        map.put("py", "Paraguay");
        map.put("pe", "Peru");
        map.put("ph", "Philippines");
        map.put("pn", "Pitcairn");
        map.put("pl", "Poland");
        map.put("pt", "Portugal");
        map.put("pr", "Puerto Rico");
        map.put("qa", "Qatar");
        map.put("re", "R\u00E9union");
        map.put("ro", "Romania");
        map.put("ru", "Russian Federation");
        map.put("rw", "Rwanda");
        map.put("bl", "Saint Barth\u00E9lemy");
        map.put("sh", "Saint Helena, Ascension and Tristan da Cunha");
        map.put("kn", "Saint Kitts and Nevis");
        map.put("lc", "Saint Lucia");
        map.put("mf", "Saint Martin (French part)");
        map.put("pm", "Saint Pierre and Miquelon");
        map.put("vc", "Saint Vincent and the Grenadines");
        map.put("ws", "Samoa");
        map.put("sm", "San Marino");
        map.put("st", "Sao Tome and Principe");
        map.put("sa", "Saudi Arabia");
        map.put("sn", "Senegal");
        map.put("rs", "Serbia");
        map.put("sc", "Seychelles");
        map.put("sl", "Sierra Leone");
        map.put("sg", "Singapore");
        map.put("sx", "Sint Maarten (Dutch part)");
        map.put("sk", "Slovakia");
        map.put("si", "Slovenia");
        map.put("sb", "Solomon Islands");
        map.put("so", "Somalia");
        map.put("za", "South Africa");
        map.put("gs", "South Georgia and the South Sandwich Islands");
        map.put("ss", "South Sudan");
        map.put("es", "Spain");
        map.put("lk", "Sri Lanka");
        map.put("sd", "Sudan");
        map.put("sr", "Suriname");
        map.put("sj", "Svalbard and Jan Mayen");
        map.put("sz", "Eswatini");
        map.put("se", "Sweden");
        map.put("ch", "Switzerland");
        map.put("sy", "Syrian Arab Republic");
        map.put("tw", "Taiwan, Province of China");
        map.put("tj", "Tajikistan");
        map.put("tz", "Tanzania, United Republic of");
        map.put("th", "Thailand");
        map.put("tl", "Timor-Leste");
        map.put("tg", "Togo");
        map.put("tk", "Tokelau");
        map.put("to", "Tonga");
        map.put("tt", "Trinidad and Tobago");
        map.put("tn", "Tunisia");
        map.put("tr", "Turkey");
        map.put("tm", "Turkmenistan");
        map.put("tc", "Turks and Caicos Islands");
        map.put("tv", "Tuvalu");
        map.put("ug", "Uganda");
        map.put("ua", "Ukraine");
        map.put("ae", "United Arab Emirates");
        map.put("gb", "United Kingdom");
        map.put("us", "United States");
        map.put("um", "United States Minor Outlying Islands");
        map.put("uy", "Uruguay");
        map.put("uz", "Uzbekistan");
        map.put("vu", "Vanuatu");
        map.put("ve", "Venezuela, Bolivarian Republic of");
        map.put("vn", "Viet Nam");
        map.put("vg", "Virgin Islands, British");
        map.put("vi", "Virgin Islands, U.S.");
        map.put("wf", "Wallis and Futuna");
        map.put("eh", "Western Sahara");
        map.put("ye", "Yemen");
        map.put("zm", "Zambia");
        map.put("zw", "Zimbabwe");
        COUNTRY_MAP = Collections.unmodifiableMap(map);
    }

    static String extractDomain(String inputUrl) {
        try {
            URL url = new URL(inputUrl);
            return url.getHost().replace("www.", "");
        } catch (MalformedURLException e) {
            return "";
        }
    }

    static String extractBaseUrl(String inputUrl) {
        try {
            URL url = new URL(inputUrl);
            String protocol = url.getProtocol();
            String host = url.getHost();
            return protocol + "://" + host;
        } catch (MalformedURLException e) {
            // Optional: handle URLs without protocol
            try {
                URL url = new URL("https://" + inputUrl);
                return "https://" + url.getHost();
            } catch (MalformedURLException ex) {
                return ""; // invalid URL
            }
        }
    }

    static String getDomainCountry(String url) {
        if (url == null || url.isEmpty()) {
            return "";
        }
        String host;
        try {
            if (url.startsWith("http://") || url.startsWith("https://")) {
                host = new URL(url).getHost();
            } else {
                host = url;
            }
        } catch (MalformedURLException ex) {
            return "";
        }
        host = host.toLowerCase();
        host = host.replaceFirst(":\d+$", "");
        String[] parts = host.split("\\.");
        if (parts.length == 0) {
            return "";
        }
        String tld = parts[parts.length - 1];
        String name = COUNTRY_MAP.get(tld);
        return name != null ? name : "";
    }
}
