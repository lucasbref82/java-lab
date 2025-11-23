package interfaces;

import interfaces.entidades.AluguelCarro;
import interfaces.entidades.Veiculo;

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

            System.out.println("Entrada (dd/MM/yyyy hh:mm): ");
            LocalDateTime entrada = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

            System.out.println("Saida (dd/MM/yyyy hh:mm): ");
            LocalDateTime saida = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);

            AluguelCarro aluguelCarro = new AluguelCarro(entrada, saida, new Veiculo(modeloCarro));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o programa !" + e.getMessage());
            e.printStackTrace();
        }
    }
}
