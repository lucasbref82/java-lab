package estrutura_dados.lista;

import estrutura_dados.entidades.Funcionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class OperacoesFuncionario {

    private static final Logger log = LoggerFactory.getLogger(OperacoesFuncionario.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            scanner.useLocale(Locale.US);
            System.out.print("Quantos funcionários você quer registrar? ");
            int quantidadeFuncionarios = scanner.nextInt();
            List<Funcionario> funcionarioList = new ArrayList<>();
            System.out.println();
            for (int i = 1; i <= quantidadeFuncionarios; i++) {
                System.out.println(Utils.format("Funcionário #{}", i));
                System.out.print("Id: ");
                Integer id = scanner.nextInt();
                System.out.print("Nome: ");
                scanner.nextLine();
                String nome = scanner.nextLine();
                System.out.print("Salário: ");
                BigDecimal salario = scanner.nextBigDecimal();
                funcionarioList.add(new Funcionario(salario, nome, id));
                System.out.println();
            }
            System.out.print("Entre com o ID do funcionário que deseja acrescentar o salário: ");
            int idFuncionario = scanner.nextInt();
            System.out.print("Digite a porcentagem: ");
            BigDecimal porcentagem = scanner.nextBigDecimal();

            System.out.println();

            Funcionario funcionario = funcionarioList.stream().filter(f -> f.getId().equals(idFuncionario)).findFirst().orElseThrow(() -> new Exception("Nenhum funcionário encontrado."));
            funcionario.acrescentarPorcentagem(porcentagem);
            System.out.println("Lista de funcionários: ");
            for(Funcionario f : funcionarioList) {
                System.out.println(f);
            }
        } catch (Exception e) {
            log.error(Utils.format("Ocorreu um erro na operação: {}", e.getMessage()));
        }

    }
}
