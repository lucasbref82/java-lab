package polimorfismo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polimorfismo.entidades.Funcionario;
import polimorfismo.entidades.FuncionarioTerceirizado;
import utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    private static final Logger log = LoggerFactory.getLogger(Principal.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.print("Digite o número de funcionários: ");
            Integer n = scanner.nextInt();
            List<Funcionario> funcionarioList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                scanner.nextLine();
                System.out.println("Digite os dados do funcionário #" + i);
                System.out.print("Terceirizado (s/n) ? ");
                char terceirizado = scanner.nextLine().trim().charAt(0);
                System.out.print("Nome: ");
                String nome = scanner.nextLine().trim();
                System.out.print("Horas: ");
                Integer horas = scanner.nextInt();
                System.out.print("Valor por hora: ");
                BigDecimal valorPorHora = scanner.nextBigDecimal();
                if (terceirizado == 's') {
                    System.out.print("Valor adicional: ");
                    BigDecimal valorAdicional = scanner.nextBigDecimal();
                    funcionarioList.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, valorAdicional));
                } else {
                    funcionarioList.add(new Funcionario(nome, horas, valorPorHora));
                }
            }
            System.out.println();
            System.out.println("PAGAMENTOS: ");
            for (Funcionario funcionario : funcionarioList) {
                System.out.println(Utils.format("{} - $ {}", funcionario.getNome(), funcionario.pagamento()));
            }
        } catch (Exception e) {
            log.error(Utils.format("Ocorreu algum erro na operação - {}", e.getMessage()), e);
        }
    }
}
