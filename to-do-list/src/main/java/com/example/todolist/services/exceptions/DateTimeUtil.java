package com.example.todolist.services.exceptions;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static String formatInstant(Instant instant) {
        return FORMATTER.format(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    }

}
