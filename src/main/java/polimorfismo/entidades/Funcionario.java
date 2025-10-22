package polimorfismo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {

    protected String nome;
    protected Integer horas;
    protected BigDecimal valorPorHora;


    public BigDecimal pagamento() {
        return valorPorHora.multiply(BigDecimal.valueOf(horas));
    }

    @Override
    public boolean equals(Object objeto) {
        if(objeto == null || objeto.getClass() != getClass()) return false;
        Funcionario that = (Funcionario) objeto;
        return Objects.equals(that.getNome(), nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
