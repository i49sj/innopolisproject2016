package server.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by User on 31.10.2016.
 */
public class TimeUtil {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate ldt) {
        return ldt == null ? "" : ldt.format(DATE_FORMATTER);
    }
}
