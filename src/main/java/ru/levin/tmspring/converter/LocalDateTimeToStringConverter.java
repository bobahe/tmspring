package ru.levin.tmspring.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToStringConverter implements Converter<LocalDate, String> {

    @Override
    public String convert(final LocalDate s) {
        if (s == null) return null;
        return s.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
