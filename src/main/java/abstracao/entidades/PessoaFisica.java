package abstracao.entidades;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa{

    private static final BigDecimal PORCETAGEM_ABAIXO_VINTE_MIL = BigDecimal.valueOf(0.15);
    private static final BigDecimal PORCETAGEM_ACIMA_VINTE_MIL = BigDecimal.valueOf(0.25);
    private static final BigDecimal BASE_CALCULO_RENDA = BigDecimal.valueOf(20000.00);
    private static final Integer DESCONTO_GASTO_SAUDE = 50;

    private BigDecimal gastosComSaude = BigDecimal.ZERO;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, BigDecimal rendaAnual, BigDecimal gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public BigDecimal calculaImposto() {
        BigDecimal impostoAnual = BigDecimal.ZERO;
        BigDecimal gastosSaude = BigDecimal.ZERO;
        if (rendaAnual.compareTo(BASE_CALCULO_RENDA) > 0) {
            gastosSaude = gastosComSaude.compareTo(BigDecimal.ZERO) > 0 ? gastosComSaude.divide(BigDecimal.valueOf(DESCONTO_GASTO_SAUDE)) : BigDecimal.ZERO;
            impostoAnual = rendaAnual.multiply(PORCETAGEM_ACIMA_VINTE_MIL).add(gastosSaude);
        } else {
            impostoAnual = rendaAnual.multiply(PORCETAGEM_ACIMA_VINTE_MIL).add(gastosSaude);
        }
    }

    public BigDecimal getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(BigDecimal gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }
}
