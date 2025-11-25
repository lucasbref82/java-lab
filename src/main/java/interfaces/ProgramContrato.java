package interfaces;

import interfaces.entidades.Contrato;
import interfaces.services.ContratoService;
import interfaces.services.ParcelaService;
import interfaces.services.PaypalService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramContrato {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {

            scanner.useLocale(Locale.US);
            System.out.println("Digite os dados do contrato: ");
            System.out.print("Numero: ");
            Integer numeroContrato = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Data (dd/MM/yyyy): ");
            String dataContrato = scanner.nextLine();
            System.out.print("Digite o valor do cotrato: ");
            BigDecimal valorContrato = scanner.nextBigDecimal();

            Contrato contrato = new Contrato(numeroContrato, LocalDate.parse(dataContrato, DateTimeFormatter.ofPattern("dd/MM/yyyy")), valorContrato);

            System.out.print("Digite a quantidade de meses: ");
            int meses = scanner.nextInt();

            ContratoService contratoService = new ContratoService(new PaypalService());
            contratoService.processaContratos(contrato, meses);

            ParcelaService parcelaService = new ParcelaService();
            parcelaService.imprimeParcelas(contrato.getParcelas());

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o programa.");
            e.printStackTrace();
        }
        System.out.println("Digite os dados do contrato: ");

    }
}
