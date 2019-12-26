package ru.levin.tmspring.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(final String s) {
        if (s == null || s.isEmpty()) return null;
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
