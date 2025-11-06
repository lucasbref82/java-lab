package interfaces.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Estacionamento {

    private String modeloCarro;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private BigDecimal precoPorHora;
    private BigDecimal precoPorDia;

    public Estacionamento() {}

    public Estacionamento(String modeloCarro, LocalDateTime entrada, LocalDateTime saida, BigDecimal precoPorHora, BigDecimal precoPorDia) {
        this.modeloCarro = modeloCarro;
        this.entrada = entrada;
        this.saida = saida;
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String modeloCarro;
        private LocalDateTime entrada;
        private LocalDateTime saida;
        private BigDecimal precoPorHora;
        private BigDecimal precoPorDia;

        public Builder modeloCarro(String modeloCarro) {
            this.modeloCarro = modeloCarro;
            return this;
        }

        public Builder entrada(LocalDateTime entrada) {
            this.entrada = entrada;
            return this;
        }

        public Builder saida(LocalDateTime saida) {
            this.saida = saida;
            return this;
        }

        public Builder precoPorHora(BigDecimal precoPorHora) {
            this.precoPorHora = precoPorHora;
            return this;
        }

        public Builder precoPorDia(BigDecimal precoPorDia) {
            this.precoPorDia = precoPorDia;
            return this;
        }

        public Estacionamento build() {
            return new Estacionamento(modeloCarro, entrada, saida, precoPorHora, precoPorDia);
        }
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
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

    public BigDecimal getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(BigDecimal precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public BigDecimal getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(BigDecimal precoPorDia) {
        this.precoPorDia = precoPorDia;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estacionamento that = (Estacionamento) o;
        return Objects.equals(modeloCarro, that.modeloCarro) && Objects.equals(entrada, that.entrada) && Objects.equals(saida, that.saida) && Objects.equals(precoPorHora, that.precoPorHora) && Objects.equals(precoPorDia, that.precoPorDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modeloCarro, entrada, saida, precoPorHora, precoPorDia);
    }
}
