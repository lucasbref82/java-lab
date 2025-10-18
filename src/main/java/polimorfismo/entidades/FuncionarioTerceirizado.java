package polimorfismo.entidades;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class FuncionarioTerceirizado extends Funcionario {

    private BigDecimal valorAdicional;
    private static final BigDecimal VALOR_ACRESCIMO = BigDecimal.valueOf(0.10);

    public FuncionarioTerceirizado() {
        super();
    }

    public FuncionarioTerceirizado(String nome, Integer horas, BigDecimal valorPorHora, BigDecimal valorAdicional) {
        super(nome,horas,valorPorHora);
        this.valorAdicional = valorAdicional;
    }

    @Override
    public BigDecimal pagamento() {
        BigDecimal valorComplementar = valorAdicional.multiply(VALOR_ACRESCIMO);
        return super.pagamento().add(valorComplementar).add(valorAdicional);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        FuncionarioTerceirizado that = (FuncionarioTerceirizado) object;
        return Objects.equals(valorAdicional, that.valorAdicional);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorAdicional);
    }
}
