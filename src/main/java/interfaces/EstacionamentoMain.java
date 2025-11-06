package interfaces;

import interfaces.entidades.Estacionamento;
import interfaces.service.EstacionamentoService;
import utils.TimeUtils;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class EstacionamentoMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            scanner.useLocale(Locale.US);

            System.out.print("Modelo do carro: ");
            String modeloCarro = scanner.nextLine();

            System.out.print("Entrada (dd/MM/yyyy hh:mm): ");
            String dataEntrada = scanner.nextLine();

            System.out.print("Data saída (dd/MM/yyyy hh:mm): ");
            String dataSaida = scanner.nextLine();

            System.out.print("Digite o preço por hora: ");
            BigDecimal precoPorHora = scanner.nextBigDecimal();

            System.out.println("Digite o preço por dia: ");
            BigDecimal precoPorDia = scanner.nextBigDecimal();

            Estacionamento estacionamento =
                    Estacionamento.builder()
                            .modeloCarro(modeloCarro)
                            .entrada(TimeUtils.parserLocalDateTimeBr(dataEntrada))
                            .saida(TimeUtils.parserLocalDateTimeBr(dataSaida))
                            .precoPorHora(precoPorHora)
                            .precoPorDia(precoPorDia)
                            .build();

            EstacionamentoService estacionamentoService = new EstacionamentoService(estacionamento);

            estacionamentoService.notaFiscal();
        } catch (Exception e) {
            System.out.println("Ocorreu um errro na aplicação: ");
        }
    }
}
