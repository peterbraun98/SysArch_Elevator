package Utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class UtilsDateTimeTest {
    @Test

    public void testDateParsing(){
        String iso8601String = "2021-12-29T11:56:38.481Z";
        Instant dateIso8601 = Instant.parse(iso8601String);
        Date date = Date.from(dateIso8601);

        System.out.println("Input String in ISO8601 is:" + iso8601String);
        assertEquals(iso8601String, UtilsDateTime.getDateString(date));
        assertEquals(date, UtilsDateTime.getDateFromString(iso8601String));
    }
}
