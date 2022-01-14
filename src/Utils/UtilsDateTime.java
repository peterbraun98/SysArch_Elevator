package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
/**
 * @author Daniel Wassmer
 */
public class UtilsDateTime {
    /**
     * Converts a Date into a ISO 8601 String at UTC timezone
     * @param date time to convert into ISO 8601
     * @return ISO 8601 date in UTC
     */
    public static String getDateString(Date date){
        return date.toInstant().toString();
    }

    /**
     * Converts a ISO 8601 String into a date instance
     * @param date ISO 8601 String of a date
     * @return Date instance of the ISO 8601 String
     */
    public static Date getDateFromString(String date){
        return Date.from(Instant.parse(date));
    }
}
