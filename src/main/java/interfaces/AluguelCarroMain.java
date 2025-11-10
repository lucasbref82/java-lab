package interfaces;

import interfaces.model.entidades.AluguelCarro;
import interfaces.model.entidades.Veiculo;
import utils.TimeUtils;

import java.util.Locale;
import java.util.Scanner;

public class AluguelCarroMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            scanner.useLocale(Locale.US);

            System.out.print("Modelo do carro: ");
            String modeloCarro = scanner.nextLine();

            System.out.print("Entrada (dd/MM/yyyy hh:mm): ");
            String dataEntrada = scanner.nextLine();

            System.out.print("Data saída (dd/MM/yyyy hh:mm): ");
            String dataSaida = scanner.nextLine();

            AluguelCarro aluguelCarro =
                    AluguelCarro.builder()
                            .entrada(TimeUtils.parserLocalDateTime(dataEntrada, TimeUtils.LOCAL_DATE_TIME_PT_BR))
                            .saida(TimeUtils.parserLocalDateTime(dataSaida, TimeUtils.LOCAL_DATE_TIME_PT_BR))
                            .veiculo(Veiculo.builder()
                                    .nome(modeloCarro)
                                    .build()
                            ).build();

        } catch (Exception e) {
            System.out.println("Ocorreu um errro na aplicação: ");
        }
    }
}
