package ru.levin.tmspring.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter(value = LocalDateConverter.ID)
public class LocalDateConverter implements Converter {

    public static final String ID = "ru.levin.tmspring.converter.LocalDateConverter";

    @Override
    public Object getAsObject(final FacesContext facesContext, final UIComponent uiComponent, final String value) {
        if (value == null || value.isEmpty()) return null;
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String getAsString(final FacesContext facesContext, final UIComponent uiComponent, final Object value) {
        return ((LocalDate) value).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
