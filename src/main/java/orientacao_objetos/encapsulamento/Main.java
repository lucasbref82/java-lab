package orientacao_objetos.encapsulamento;

import orientacao_objetos.encapsulamento.model.ContaBancaria;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Entre com o número da conta: ");
            int numeroConta = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Entre com o titular da conta: ");
            String titularConta = scanner.nextLine();
            System.out.print("Deseja fazer um depósito inicial? (s/n): ");
            char ehDepositoInicial = scanner.nextLine().charAt(0);
            ContaBancaria contaBancaria;
            if (ehDepositoInicial == 's') {
                System.out.print("Digite o valor incial a ser depositado: ");
                BigDecimal valorDeposito = scanner.nextBigDecimal();
                contaBancaria = new ContaBancaria(numeroConta, titularConta, valorDeposito);
            } else {
                contaBancaria = new ContaBancaria(numeroConta, titularConta);
            }
            System.out.println();

            System.out.println("Dados da conta: ");
            System.out.println(contaBancaria);
            System.out.println();

            System.out.print("Digite o valor a ser depositado: ");
            BigDecimal valorDepositado = scanner.nextBigDecimal();
            contaBancaria.depositar(valorDepositado);
            System.out.println("Dados da conta atualizados: ");
            System.out.println(contaBancaria);

            System.out.println();

            System.out.print("Digite o valor a ser sacado: ");
            BigDecimal valorSacado = scanner.nextBigDecimal();
            contaBancaria.sacar(valorSacado);
            System.out.println("Dados da conta atualizados: ");
            System.out.println(contaBancaria);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
