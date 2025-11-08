package interfaces;

import interfaces.entidades.AluguelCarro;
import interfaces.entidades.Fatura;
import interfaces.entidades.Veiculo;
import interfaces.service.AluguelCarroService;
import utils.TimeUtils;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class AluguelCarroMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            scanner.useLocale(Locale.US);

            System.out.print("Modelo do carro: ");
            String modeloCarro = scanner.nextLine();

            System.out.print("Entrada (dd/MM/yyyy hh:mm): ");
            String dataEntrada = scanner.nextLine();

            System.out.print("Data saída (dd/MM/yyyy hh:mm): ");
            String dataSaida = scanner.nextLine();

            System.out.print("Digite o preço do pagamento básico:  ");
            BigDecimal pagamentoBasico = scanner.nextBigDecimal();

            System.out.println("Digite a taxa: ");
            BigDecimal taxa = scanner.nextBigDecimal();

            AluguelCarro aluguelCarro =
                    AluguelCarro.builder()
                            .entrada(TimeUtils.parserLocalDateTime(dataEntrada, TimeUtils.LOCAL_DATE_TIME_PT_BR))
                            .saida(TimeUtils.parserLocalDateTime(dataSaida, TimeUtils.LOCAL_DATE_TIME_PT_BR))
                            .veiculo(Veiculo.builder()
                                    .nome(modeloCarro)
                                    .build()
                            ).fatura(Fatura.builder()
                                    .pagamentoBasico(pagamentoBasico)
                                    .taxa(taxa)
                                    .build()
                            ).build();


            AluguelCarroService estacionamentoService = new AluguelCarroService(aluguelCarro);

            estacionamentoService.notaFiscal();
        } catch (Exception e) {
            System.out.println("Ocorreu um errro na aplicação: ");
        }
    }
}
