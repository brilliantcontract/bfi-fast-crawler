package bc.bfi.crawler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PhoneNumbersCoverageTest {

    private final Parser parser = new Parser();

    @Test
    public void testAllProvidedPhoneNumbersAreExtracted() {
        String[] phones = new String[]{
            "260 420-6945",
            "207- 846-9559",
            "630-606-1910",
            "252-333-1510",
            "(877) 637-3929",
            "606) 633-3929",
            "1 (615) 372-9775",
            "(509) 926-9113",
            "(518) 279-3810",
            "(518) 279-3820",
            "(208) 896-4673",
            "907 245 1251",
            "800-258-6376",
            "(215) 677-8820",
            "(800) 258-6376",
            "215-677-9046",
            "808-533-5416",
            "415-641-1878",
            "415-641-4082",
            "301.478.6379",
            "(480) 987-4888",
            "(480) 816-7039",
            "305-573-4337",
            "301-933-8600",
            "301-468-3700",
            "302.539.7700",
            "302-539-6514",
            "(916) 641-0661",
            "18134934564",
            "(857) 229-1601",
            "814-265-1111",
            "814-827-4445",
            "(716) 759-6985",
            "912.764.6405",
            "912.764.7221",
            "301-934-8799",
            "3166847281",
            "(352) 372-1004",
            "(352) 372-0894",
            "(910)378-2501",
            "203.235.2333",
            "888.835.2333",
            "203.235.2913",
            "206-343-1223",
            "800-634-4449",
            "402.339.1660",
            "207-284-4181",
            "207-284-4181",
            "33-0704378",
            "716-614-6222"
        };

        for (String phone : phones) {
            String html = "call us " + phone + " today";
            String extracted = parser.extractPhone(html);
            assertThat("Failed for phone: " + phone, extracted, is(phone));
        }
    }
}
