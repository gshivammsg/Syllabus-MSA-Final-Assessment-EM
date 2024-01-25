package com.em.syllabus.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static com.em.syllabus.constants.Constants.IST_ZONE_ID;

public final class Utils {
    public static String getCurrentServerTime() {
        LocalDateTime ldt = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.of(IST_ZONE_ID)).toLocalDateTime();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ldt.format(format1);
    }
}

