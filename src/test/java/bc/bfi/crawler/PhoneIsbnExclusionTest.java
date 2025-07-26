package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PhoneIsbnExclusionTest {

    private final Parser parser = new Parser();

    @Test
    public void testIsbnNumbersAreIgnored() {
        String text = "Avon:  2/18/2020\n" +
                "ISBN: 978-0062371942\n" +
                "Avon:  2/19/2019\n" +
                "ISBN: 9780062371898\n" +
                "Avon:  2/27/2018\n" +
                "ISBN: 9780062371898\n" +
                "Avon:   2/2017\n" +
                "ISBN: 978-0062371874\n" +
                "Avon: 5/31/2016\n" +
                "ISBN-13: 9780062371850\n" +
                "Avon:  10/27/2015\n" +
                "ISBN-13: 9780062371812\n" +
                "Avon:  7/27/2021\n" +
                "ISBN: 978-0062371966";

        String phones = parser.extractPhone(text);
        assertThat(phones, is(""));
    }
}
