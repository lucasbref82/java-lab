package orientacao_objetos.introducao.porcentagem;

import orientacao_objetos.introducao.model.Funcionario;

import java.util.Locale;
import java.util.Scanner;

public class Porcentagem {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Salário Bruto: ");
            double salarioBruto = scanner.nextDouble();
            System.out.print("Imposto: ");
            double imposto = scanner.nextDouble();
            Funcionario funcionario = new Funcionario(nome, salarioBruto, imposto);
            System.out.println();
            System.out.printf("Funcionário: %s, $ %.2f\n", funcionario.getNome(), funcionario.salarioLiquido());
            System.out.println();
            System.out.print("Qual porcentagem deseja adicionar ao salário? ");
            double porcentagem = scanner.nextDouble();
            funcionario.aumentoSalario(porcentagem);
            System.out.println();
            System.out.printf("Dados atualizados: %s, $ %.2f", funcionario.getNome() ,funcionario.salarioLiquido());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
