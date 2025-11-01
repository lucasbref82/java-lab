/**
 * Utilitários para operações com datas e temporais (LocalDate, LocalDateTime e demais implementações de
 * {@link java.time.temporal.Temporal}).
 *
 * <p>Esta classe reúne métodos estáticos para cálculo de diferenças entre datas/temporais, validação
 * de intervalos e parsing de {@link java.time.LocalDate} no formato brasileiro <code>dd/MM/yyyy</code>.
 * A classe foi projetada para ser uma utilitária pura e não pode ser instanciada.</p>
 *
 * <h3>Comportamento geral</h3>
 * <ul>
 *   <li>Os métodos que comparam dois temporais exigem que ambos sejam do mesmo tipo lógico (por exemplo,
 *       {@link java.time.LocalDate} com {@link java.time.LocalDate} ou {@link java.time.LocalDateTime}
 *       com {@link java.time.LocalDateTime}).</li>
 *   <li>Caso os argumentos sejam inválidos (nulos, tipos diferentes ou intervalo inválido — data inicial
 *       posterior à data final), os métodos lançam {@link IllegalArgumentException}.</li>
 * </ul>
 *
 * <h3>Exemplos</h3>
 * <pre>{@code
 * LocalDate d1 = LocalDate.of(2025, 1, 1);
 * LocalDate d2 = LocalDate.of(2025, 1, 5);
 * long dias = TimeUtils.diferencaDatasEmDias(d1, d2); // 4
 *
 * LocalDateTime t1 = LocalDateTime.of(2025, 1, 1, 10, 0);
 * LocalDateTime t2 = LocalDateTime.of(2025, 1, 1, 12, 30);
 * long horas = TimeUtils.diferencaDataEmHoras(t1, t2); // 2
 *
 * LocalDate parsed = TimeUtils.parserLocalDateBr("21/10/2025");
 * }</pre>
 *
 * @author Lucas Brenner Ferreira
 * @since 1.0
 */
package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class TimeUtils {

    /**
     * Formatter para o padrão brasileiro: <code>dd/MM/yyyy</code>.
     */
    public static final DateTimeFormatter LOCAL_DATE_PT_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construtor privado para evitar instanciação. Sempre lança {@link IllegalAccessException} caso invocado
     * via reflexão ou tentativa acidental de criação de instância.
     *
     * @throws IllegalAccessException sempre que chamado (esta classe é utilitária e não deve ser instanciada)
     */
    private TimeUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Classe utilitária " + TimeUtils.class.getName() + " não pode ser instânciada.");

    }

    /**
     * Calcula a diferença em dias entre duas {@link LocalDate}.
     *
     * <p>Os argumentos devem ser ambos {@link LocalDate} e a data inicial não pode ser posterior à data final.
     * A validação é feita por {@link #validaDatasTemporais(Temporal, Temporal)}.</p>
     *
     * @param l1 data inicial (inclusive)
     * @param l2 data final (exclusive)
     * @return número de dias entre <code>l1</code> e <code>l2</code> (0 se iguais)
     * @throws IllegalArgumentException se os argumentos forem nulos, de tipos diferentes ou se a data inicial for
     *                                  posterior à data final
     * @see #validaDatasTemporais(Temporal, Temporal)
     */
    public static long diferencaDatasEmDias(LocalDate l1, LocalDate l2) {
        validaDatasTemporais(l1, l2);
        return ChronoUnit.DAYS.between(l1, l2);
    }

    /**
     * Calcula a diferença em horas entre duas {@link LocalDateTime}.
     *
     * @param l1 data/hora inicial
     * @param l2 data/hora final
     * @return número de horas inteiras entre <code>l1</code> e <code>l2</code>
     * @throws IllegalArgumentException se os argumentos forem nulos, de tipos diferentes ou se a data/hora inicial
     *                                  for posterior à data/hora final
     */
    public static long diferencaDataEmHoras(LocalDateTime l1, LocalDateTime l2) {
        validaDatasTemporais(l1, l2);
        return ChronoUnit.HOURS.between(l1, l2);
    }

    /**
     * Calcula a diferença entre dois objetos que implementam {@link Temporal} usando a unidade informada.
     *
     * <p> É útil quando você quer calcular diferenças em unidades variadas (dias, horas, minutos,
     * etc.) para quaisquer implementações de {@link Temporal} suportadas pelo <code>ChronoUnit</code>.
     * Não há conversão automática entre tipos (por exemplo, {@link LocalDate} e {@link LocalDateTime}); ambos
     * os argumentos devem ser compatíveis com a unidade desejada.</p>
     *
     * @param t1   temporal inicial (não nulo)
     * @param t2   temporal final (não nulo)
     * @param unit unidade de tempo para a diferença (ex: {@link ChronoUnit#DAYS}, {@link ChronoUnit#HOURS})
     * @return diferença entre <code>t1</code> e <code>t2</code> na unidade informada
     * @throws IllegalArgumentException se <code>t1</code>, <code>t2</code> ou <code>unit</code> forem nulos
     * @see ChronoUnit
     */
    public static long diferencaEntreTemporais(Temporal t1, Temporal t2, ChronoUnit unit) {
        if (t1 == null || t2 == null) throw new IllegalArgumentException("Temporal não pode ser nulo.");
        if (unit == null) throw new IllegalArgumentException("ChronoUnit não pode ser nulo.");
        return unit.between(t1, t2);

    }

    /**
     * Valida se os dois temporais são do mesmo tipo lógico e se o primeiro não é posterior ao segundo.
     *
     * <p>Suporta atualmente {@link LocalDate} e {@link LocalDateTime}. Se os argumentos forem de tipos diferentes
     * (por exemplo, {@code LocalDate} vs {@code LocalDateTime}) ou de tipos não suportados, será lançada
     * {@link IllegalArgumentException}.</p>
     *
     * @param d1 temporal inicial
     * @param d2 temporal final
     * @throws IllegalArgumentException quando os argumentos forem nulos, de tipos diferentes, tipos não suportados ou
     *                                  quando a data/hora inicial for posterior à data/hora final
     */
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

    /**
     * Faz o parsing de uma {@link LocalDate} no formato brasileiro <code>dd/MM/yyyy</code>.
     *
     * @param localDateString string contendo a data no formato <code>dd/MM/yyyy</code>
     * @return instância de {@link LocalDate} correspondente à string informada
     * @throws DateTimeParseException  quando a string não estiver no formato esperado ou contiver valores inválidos
     * @throws IllegalArgumentException quando <code>localDateString</code> for nulo
     */
    public static LocalDate parserLocalDateBr(String localDateString) {
        if (localDateString == null) throw new IllegalArgumentException("localDateString não pode ser nulo.");
        return LocalDate.parse(localDateString, LOCAL_DATE_PT_BR);
    }
}
