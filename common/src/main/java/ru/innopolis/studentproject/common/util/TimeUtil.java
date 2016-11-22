package ru.innopolis.studentproject.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by innopolis on 17.11.16.
 */
public class TimeUtil {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate ldt) {
        return ldt == null ? "" : ldt.format(DATE_FORMATTER);
    }
}
