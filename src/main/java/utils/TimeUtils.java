package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class TimeUtils {

    public static final DateTimeFormatter LOCAL_DATE_PT_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private TimeUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Classe utilitária " + getClass().getName() + " não pode ser instânciada.");

    }

    public static long diferencaDatasEmDias(LocalDate l1, LocalDate l2) {
        validaDatasTemporais(l1, l2);
        return ChronoUnit.DAYS.between(l1, l2);
    }

    public static long diferencaDataEmHoras(LocalDateTime l1, LocalDateTime l2) {
        validaDatasTemporais(l1, l2);
        return ChronoUnit.HOURS.between(l1, l2);
    }

    public static long diferencaEntreTemporais(Temporal t1, Temporal t2, ChronoUnit unit) {
        if (t1 == null || t2 == null) throw new IllegalArgumentException("Temporal não pode ser nulo.");
        return unit.between(t1, t2);
    }

    public static void validaDatasTemporais(Temporal d1, Temporal d2) {
        if (d1 instanceof LocalDate && d2 instanceof LocalDate) {
            if (((LocalDate) d1).isAfter((LocalDate) d2))
                throw new IllegalArgumentException("Data inicial não pode ser posterior à data final.");
            return;
        }
        if (d1 instanceof LocalDateTime && d2 instanceof LocalDateTime) {
            if (((LocalDateTime) d1).isAfter((LocalDateTime) d2))
                throw new IllegalArgumentException("Data inicial não pode ser posterior à data final.");
            return;
        }
        throw new IllegalArgumentException("Tipos temporais diferentes ou não suportados (ex: LocalDate vs LocalDateTime).");
    }

    public static  LocalDate parserLocalDateBr(String localDateString) {
        return LocalDate.parse(localDateString, LOCAL_DATE_PT_BR);
    }

}

