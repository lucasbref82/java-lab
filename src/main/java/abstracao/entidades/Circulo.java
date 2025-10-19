package abstracao.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class Circulo {
    private BigDecimal raio;

    public Circulo() {
    }

    public Circulo(BigDecimal raio) {
        this.raio = raio;
    }

    public BigDecimal getRaio() {
        return raio;
    }

    public void setRaio(BigDecimal raio) {
        this.raio = raio;
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
