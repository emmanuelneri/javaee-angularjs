package br.com.emmanuelneri.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateJsonAdapter extends XmlAdapter<String, LocalDate> {

    private final static String DATE_PATTERN_DEFAULT = "dd/MM/yyyy";
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN_DEFAULT);

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString, DATE_TIME_FORMATTER);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return DATE_TIME_FORMATTER.format(localDate);
    }
}
