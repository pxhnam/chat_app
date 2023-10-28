package utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TimestampUtils {

    private static Instant instant;
    private static LocalTime time;
    private static LocalDate date;

    public static String getTime(Timestamp timestamp) {
        instant = timestamp.toInstant();
        time = instant.atZone(ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        return time.toString();
    }

    public static String getDate(Timestamp timestamp) {
        instant = timestamp.toInstant();
        date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return date.toString();
    }
}
