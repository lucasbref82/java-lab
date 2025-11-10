package interfaces.model.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class AluguelCarro {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;
    private Fatura fatura;
    public final BigDecimal PRECO_POR_HORA = new BigDecimal("10.00");
    public final BigDecimal PRECO_POR_DIA = new BigDecimal("10.00");

    public AluguelCarro() {
    }

    public AluguelCarro(LocalDateTime entrada, LocalDateTime saida, Veiculo veiculo, Fatura fatura) {
        this.entrada = entrada;
        this.saida = saida;
        this.veiculo = veiculo;
        this.fatura = fatura;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public LocalDateTime entrada;
        public LocalDateTime saida;
        public Veiculo veiculo;
        public Fatura fatura;

        public Builder entrada(LocalDateTime entrada) {
            this.entrada = entrada;
            return this;
        }

        public Builder saida(LocalDateTime saida) {
            this.saida = saida;
            return this;
        }

        public Builder veiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
            return this;
        }

        public Builder fatura(Fatura fatura) {
            this.fatura = fatura;
            return this;
        }

        public AluguelCarro build() {
            return new AluguelCarro(entrada, saida, veiculo, fatura);
        }
    }


    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AluguelCarro that = (AluguelCarro) o;
        return Objects.equals(entrada, that.entrada) && Objects.equals(saida, that.saida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrada, saida);
    }
}
