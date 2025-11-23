package interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AluguelCarro {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Veiculo veiculo;
    private Fatura fatura;

    public AluguelCarro() {
    }

    public AluguelCarro(LocalDateTime entrada, LocalDateTime saida, Veiculo veiculo, Fatura fatura) {
        this.entrada = entrada;
        this.saida = saida;
        this.veiculo = veiculo;
        this.fatura = fatura;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
