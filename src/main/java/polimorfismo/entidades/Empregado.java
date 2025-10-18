package polimorfismo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empregado {

    protected String nome;
    protected Integer horas;
    protected BigDecimal valorPorHora;


    @Override
    public boolean equals(Object objeto) {
        if( objeto == null || objeto.getClass() != getClass()) return false;
        Empregado that = (Empregado) objeto;
        return Objects.equals(that.getNome(), nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
