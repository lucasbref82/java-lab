package orientacao_objetos.introducao.estaticos.utils;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class ConversorUtils {

    private ConversorUtils() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada.");
    }

    private static final BigDecimal PORCENTAGEM_ACRESCIMO = BigDecimal.valueOf(6);
    private static final BigDecimal DIVIDENDO_PORCENTAGEM = BigDecimal.valueOf(100);
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    /**
     * Converte o valor em dólar para reais aplicando acréscimo percentual (6% por padrão).
     *
     * @param valorDolar cotação do dólar
     * @param quantidade quantidade de dólares
     * @return valor em reais com acréscimo aplicado (BigDecimal com scale definido)
     * @throws NullPointerException se valorDolar ou quantidade for null
     * @throws IllegalArgumentException se valorDolar ou quantidade for negativo
     */
    public static @NotNull BigDecimal converterDolarParaReais(BigDecimal valorDolar, BigDecimal quantidade) {
        Objects.requireNonNull(valorDolar, "valorDolar não pode ser null");
        Objects.requireNonNull(quantidade, "quantidade não pode ser null");

        if (valorDolar.signum() < 0 || quantidade.signum() < 0) {
            throw new IllegalArgumentException("Valores não podem ser negativos.");
        }

        BigDecimal valorTotal = valorDolar.multiply(quantidade);
        return aplicarAumentoPercentual(valorTotal);
    }

    private static BigDecimal aplicarAumentoPercentual(BigDecimal base) {
        BigDecimal fator = BigDecimal.ONE.add(ConversorUtils.PORCENTAGEM_ACRESCIMO.divide(DIVIDENDO_PORCENTAGEM, 10, ROUNDING_MODE));
        return base.multiply(fator).setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal converterDolarParaReais(double valorDolar, double quantidade) {
        return converterDolarParaReais(BigDecimal.valueOf(valorDolar), BigDecimal.valueOf(quantidade));
    }
}
