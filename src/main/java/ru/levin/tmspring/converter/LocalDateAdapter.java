package ru.levin.tmspring.converter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public String marshal(final LocalDate val) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return val.format(formatter);
    }

    @Override
    public LocalDate unmarshal(final String val) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            return LocalDate.parse(val, formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
