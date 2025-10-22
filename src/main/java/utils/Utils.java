package utils;

import org.slf4j.helpers.MessageFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private Utils() throws IllegalAccessException {
        throw new IllegalAccessException("Classe utilitária não pode ser instanciada.");
    }

    public static String format(String texto, Object... argumentos) {
        return MessageFormatter.basicArrayFormat(texto, argumentos);
    }

    public static String toString(Object objeto) {
        try {
            return objeto.toString();
        } catch (ClassCastException e) {
            return null;
        }
    }

    public static String toStringOrDefault(Object objeto, String valorPadrao) {
        try {
            return objeto.toString();
        } catch (ClassCastException e) {
            return valorPadrao;
        }
    }

    public static void validaSeBigdecimalZeroOuNegativo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor informado não pode ser negativo! ");
        }
    }

    public static BigDecimal calculaValorPorBaseEhPorcentagem(BigDecimal valor, BigDecimal porcentagem) {
        return valor.multiply(porcentagem);
    }

    public static boolean ehEmailValido(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = Pattern.compile(EMAIL_REGEX).matcher(email);
        return matcher.matches();
    }

    public static LocalDateTime converteCalendarParaLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
    }

    public static LocalDate converteCalendarParaLocalDate(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalDate();
    }

    public static Calendar getCalendar(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
            Date date = Date.from(zonedDateTime.toInstant());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
        return null;
    }

    public static Calendar getCalendar(LocalDate localDate) {
        if (localDate != null) {
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            Date date = Date.from(zonedDateTime.toInstant());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
        return null;
    }

    public static Integer toIntegerOrDefault(String value) {
        return toIntegerOrDefault(value, null);
    }

    public static Integer toIntegerOrDefault(String value, Integer defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Long toLongOrDefault(String value) {
        return toLongOrDefault(value, null);
    }

    public static Long toLongOrDefault(String value, Long defaultValue) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static Short toShortOrDefault(Integer value, Short defaultValue) {
        try {
            return value == null ? null : value.shortValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
