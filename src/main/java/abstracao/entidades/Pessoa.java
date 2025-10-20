package abstracao.entidades;

import java.math.BigDecimal;

public abstract class Pessoa {
    protected String nome;
    protected BigDecimal rendaAnual;

    public Pessoa() {
    }

    public Pessoa(String nome, BigDecimal rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(BigDecimal rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract BigDecimal calculaImposto();
}
