package abstracao.entidades;

import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PessoaFisica extends Pessoa{

    private static final BigDecimal ALIQUOTA_FAIXA_INFERIOR = new BigDecimal("0.15");
    private static final BigDecimal ALIQUOTA_FAIXA_SUPERIOR = new BigDecimal("0.25");
    private static final BigDecimal BASE_CALCULO_RENDA = new BigDecimal("20000.00");
    private static final Integer DESCONTO_GASTO_SAUDE = 50;

    private final BigDecimal gastosComSaude;


    public PessoaFisica(String nome, BigDecimal rendaAnual, BigDecimal gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }


    @Override
    public BigDecimal calculaImposto() {
        BigDecimal impostoAnual;
        BigDecimal gastosSaude = calculaDeducaoSaude();
        if (rendaAnual.compareTo(BASE_CALCULO_RENDA) > 0) {
            impostoAnual = Utils.calculaValorPorBaseEhPorcentagem(rendaAnual, ALIQUOTA_FAIXA_SUPERIOR).subtract(gastosSaude);
        } else {
            impostoAnual = Utils.calculaValorPorBaseEhPorcentagem(rendaAnual, ALIQUOTA_FAIXA_INFERIOR).subtract(gastosSaude);
        }
        return impostoAnual;
    }

    private BigDecimal calculaDeducaoSaude() {
        return gastosComSaude.compareTo(BigDecimal.ZERO) > 0
                ? gastosComSaude.divide(BigDecimal.valueOf(DESCONTO_GASTO_SAUDE), RoundingMode.HALF_UP)
                : BigDecimal.ZERO;
    }
}
