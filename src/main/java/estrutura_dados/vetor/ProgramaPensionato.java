package estrutura_dados.vetor;

import estrutura_dados.entidades.Pensionato;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class ProgramaPensionato {
    private static final Logger log = LoggerFactory.getLogger(ProgramaPensionato.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            System.out.print("Quantos quartos serão alugados? ");
            int n = scanner.nextInt();

            scanner.nextLine();
            Pensionato[] pensionatos = new Pensionato[10];

            for (int i = 1; i <= n; i++) {
                System.out.println(Utils.format("Aluguel #{}", i));

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Quarto (1 a " + pensionatos.length + "): ");

                int quarto = scanner.nextInt();
                scanner.nextLine();

                if (pensionatos[quarto] != null) {
                    System.out.println("Quarto já está ocupado. Escolha outro.");
                    i--;
                    continue;
                }

                pensionatos[quarto] = new Pensionato(nome, email, quarto);
            }

            System.out.println();
            System.out.println("Quartos alugados:");
            for (int i = 0; i < 10; i++) {
                if (pensionatos[i] != null) {
                    System.out.println(pensionatos[i]);
                }
            }
        } catch (Exception e) {
            log.error(Utils.format("Ocorreu algum erro ao alugar os quartos: {}", e.getMessage()), e);
        }
    }
}
