package interfaces;

import interfaces.entidades.AluguelCarro;
import interfaces.entidades.Veiculo;
import interfaces.services.AluguelService;
import interfaces.services.TaxaBrasilService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            scanner.useLocale(Locale.US);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            System.out.println("Digite os dados do aluguel: ");

            System.out.print("Modelo do carro: ");
            String modeloCarro = scanner.nextLine();

            System.out.print("Entrada (dd/MM/yyyy hh:mm): ");
            LocalDateTime entrada = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

            System.out.print("Saida (dd/MM/yyyy hh:mm): ");
            LocalDateTime saida = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

            AluguelCarro aluguelCarro = new AluguelCarro(entrada, saida, new Veiculo(modeloCarro));

            System.out.print("Digite o preço por hora: ");
            Double precoPorHora = scanner.nextDouble();

            System.out.print("Digite o preço por dia: ");
            Double precoPorDia = scanner.nextDouble();

            AluguelService aluguelService = new AluguelService(new TaxaBrasilService(), precoPorDia, precoPorHora);

            aluguelService.processarFatura(aluguelCarro);

            System.out.println("FATURA: ");
            System.out.println("Pagamento básico: " + String.format("%.2f", aluguelCarro.getFatura().getPagamentoBasico()));
            System.out.println("Imposto: " + String.format("%.2f", aluguelCarro.getFatura().getTaxa()));
            System.out.println("Pagamento total: " + String.format("%.2f", aluguelCarro.getFatura().getPagamentoTotal()));




        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o programa !" + e.getMessage());
            e.printStackTrace();
        }
    }
}
