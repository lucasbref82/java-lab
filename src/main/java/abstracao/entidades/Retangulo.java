package abstracao.entidades;

import abstracao.enums.Cor;

import java.math.BigDecimal;
import java.util.Objects;

public class Retangulo extends Forma{
    private BigDecimal largura;
    private BigDecimal altura;

    public Retangulo() {
    }

    public Retangulo(Cor cor, BigDecimal largura, BigDecimal altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    @Override
    public BigDecimal area() {
        return largura.multiply(altura);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retangulo that = (Retangulo) o;
        return Objects.equals(this.altura, that.altura) && Objects.equals(this.largura, that.largura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(largura, altura);
    }
}
