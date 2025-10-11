package utils;

import org.slf4j.helpers.MessageFormatter;

public class Utils {

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
}
