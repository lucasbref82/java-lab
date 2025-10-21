package utils;

import org.slf4j.helpers.MessageFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
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

}
