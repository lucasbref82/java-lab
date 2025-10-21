package abstracao.entidades;

import utils.Utils;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Pessoa {

    protected String nome;
    protected BigDecimal rendaAnual;

    protected Pessoa(String nome, BigDecimal rendaAnual) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo! ");
        Utils.validaSeBigdecimalZeroOuNegativo(rendaAnual);
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }


    public abstract BigDecimal calculaImposto();
}
