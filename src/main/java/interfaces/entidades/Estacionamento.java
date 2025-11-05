package interfaces.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

public class Estacionamento {
    private String modeloCarro;
    private LocalDateTime entrada;
    private LocalDateTime saida;


    public Estacionamento() {
    }

    public Estacionamento(String modeloCarro, LocalDateTime entrada, LocalDateTime saida) {
        this.modeloCarro = modeloCarro;
        this.entrada = entrada;
        this.saida = saida;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estacionamento that = (Estacionamento) o;
        return Objects.equals(modeloCarro, that.modeloCarro) && Objects.equals(entrada, that.entrada) && Objects.equals(saida, that.saida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modeloCarro, entrada, saida);
    }
}
