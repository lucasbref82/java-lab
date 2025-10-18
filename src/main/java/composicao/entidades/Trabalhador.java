package composicao.entidades;

import composicao.enums.Senioridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trabalhador {
    private String nome;
    private Senioridade senioridade;
    private BigDecimal salarioBase;
    private List<HoraContrato> horaContratos = new ArrayList<>();
    private Departamento departamento;


    public void adicionaContrato(HoraContrato horaContrato) {
        horaContratos.add(horaContrato);
    }

    public void removeContrato(HoraContrato horaContrato) {
        horaContratos.remove(horaContrato);
    }

    public BigDecimal renda(Integer ano, Integer mes) {
        BigDecimal somaContratos = BigDecimal.ZERO;
        for (HoraContrato hc : horaContratos) {
            if (hc.getData().getYear() == ano && hc.getData().getMonthValue() == mes) {
                somaContratos = somaContratos.add(hc.valorTotal());
            }
        }
        BigDecimal base = salarioBase == null ? BigDecimal.ZERO : salarioBase;
        return base.add(somaContratos);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Trabalhador that = (Trabalhador) object;
        return Objects.equals(nome, that.nome) && Objects.equals(senioridade, that.senioridade) && Objects.equals(salarioBase, that.salarioBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, senioridade, salarioBase);
    }
}
