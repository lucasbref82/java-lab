package abstracao.entidades;

import utils.Utils;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa{
    
    private final Integer numeroFuncionarios;
    private static final BigDecimal ALIQUOTA_EMPRESA_COM_MAIS_DE_DEZ_FUNCIONARIOS = new BigDecimal("0.14");
    private static final BigDecimal ALIQUOTA_EMPRESA_COM_MENOS_DE_DEZ_FUNCIONARIOS = new BigDecimal("0.16");
    private static final Integer VALOR_CORTE_PARA_CALCULO_IMPOSTO = 10;
    
    public PessoaJuridica(String nome, BigDecimal rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }
    
    @Override
    public BigDecimal calculaImposto() {
        BigDecimal impostoAnual = BigDecimal.ZERO;
        if (numeroFuncionarios > VALOR_CORTE_PARA_CALCULO_IMPOSTO) {
            impostoAnual = Utils.calculaValorPorBaseEhPorcentagem(rendaAnual, ALIQUOTA_EMPRESA_COM_MAIS_DE_DEZ_FUNCIONARIOS);
        } else {
            impostoAnual = Utils.calculaValorPorBaseEhPorcentagem(rendaAnual, ALIQUOTA_EMPRESA_COM_MENOS_DE_DEZ_FUNCIONARIOS);
        }
        return impostoAnual;
    }
}
