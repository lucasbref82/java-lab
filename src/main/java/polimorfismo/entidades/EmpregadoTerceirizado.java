package polimorfismo.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class EmpregadoTerceirizado extends Empregado{

    private BigDecimal valorAdicional;

    public EmpregadoTerceirizado() {
        super();
    }

    public EmpregadoTerceirizado(String nome, Integer horas, BigDecimal valorPorHora, BigDecimal valorAdicional) {
        super(nome,horas,valorPorHora);
        this.valorAdicional = valorAdicional;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        EmpregadoTerceirizado that = (EmpregadoTerceirizado) object;
        return Objects.equals(valorAdicional, that.valorAdicional);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorAdicional);
    }
}
