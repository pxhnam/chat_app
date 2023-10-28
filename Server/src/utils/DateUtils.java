package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String toSqlDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
