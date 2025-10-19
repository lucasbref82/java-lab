package abstracao.entidades;

import abstracao.enums.Cor;

import java.math.BigDecimal;
import java.util.Objects;

public class Circulo extends Forma{

    private BigDecimal raio;

    public Circulo() {
    }

    public Circulo(Cor cor, BigDecimal raio) {
        super(cor);
        this.raio = raio;
    }

    public BigDecimal getRaio() {
        return raio;
    }

    public void setRaio(BigDecimal raio) {
        this.raio = raio;
    }

    @Override
    public BigDecimal area() {
        return raio.multiply(raio).multiply(BigDecimal.valueOf(Math.PI));
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Circulo that = (Circulo) o;
        return Objects.equals(this.raio, that.raio);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(raio);
    }
}
