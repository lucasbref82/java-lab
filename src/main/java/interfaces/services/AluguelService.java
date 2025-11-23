package interfaces.services;

import interfaces.entidades.AluguelCarro;
import interfaces.entidades.Fatura;
import interfaces.itf.TaxaService;

import java.time.Duration;

public class AluguelService {

    private Double precoPorDia;
    private Double precoPorHora;
    private TaxaService taxaService;

    public AluguelService(TaxaService taxaService, Double precoPorHora, Double precoPorDia) {
        this.taxaService = taxaService;
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
    }

    public void processarFatura(AluguelCarro aluguelCarro) {

        double minutos = Duration.between(aluguelCarro.getEntrada(), aluguelCarro.getSaida()).toMinutes();
        double horas = minutos / 60;
        double pagamentoBasico;

        if (horas <= 12) {
            pagamentoBasico = precoPorHora * Math.ceil(horas);
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
        }

        double taxa = taxaService.taxa(pagamentoBasico);
        aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
    }

}
