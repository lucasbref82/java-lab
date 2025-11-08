package interfaces.service;

import interfaces.entidades.AluguelCarro;
import utils.TimeUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;

public class AluguelCarroService {

    private final AluguelCarro aluguelCarro;

    // Taxas percentuais
    private static final BigDecimal TAXA_VALORES_ATE_CEM_REAIS = new BigDecimal("20");
    private static final BigDecimal TAXA_VALORES_ACIMA_CEM_REAIS = new BigDecimal("15");
    private static final BigDecimal DIVIDENDO = new BigDecimal("100");

    public AluguelCarroService(AluguelCarro aluguelCarro) {
        this.aluguelCarro = aluguelCarro;
    }

    private Long calculaDuracao() {
        long minutos = TimeUtils.diferencaEntreTemporais(
                aluguelCarro.getEntrada(),
                aluguelCarro.getSaida(),
                ChronoUnit.MINUTES
        );
        long horas = minutos / 60;
        if (minutos % 60 != 0) {
            horas += 1;
        }

        return horas;
    }

    private BigDecimal calculaPagamentoBasico() {
        return new BigDecimal(calculaDuracao()).multiply(aluguelCarro.PRECO_POR_HORA);
    }

    private BigDecimal calculaTaxa() {
        BigDecimal pagamentoBasico = calculaPagamentoBasico();
        BigDecimal taxaPercentual = pagamentoBasico.compareTo(new BigDecimal("100")) <= 0
                ? TAXA_VALORES_ATE_CEM_REAIS
                : TAXA_VALORES_ACIMA_CEM_REAIS;

        return taxaPercentual
                .divide(DIVIDENDO, 2, RoundingMode.HALF_EVEN)
                .multiply(pagamentoBasico);
    }

    private BigDecimal calculaValorTotal() {
        return calculaPagamentoBasico().add(calculaTaxa());
    }

    public void notaFiscal() {
        System.out.println("=== NOTA FISCAL ===");
        System.out.println("Pagamento básico: R$ " + calculaPagamentoBasico().setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("Taxa: R$ " + calculaTaxa().setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("Valor total: R$ " + calculaValorTotal().setScale(2, RoundingMode.HALF_EVEN));
    }
}
