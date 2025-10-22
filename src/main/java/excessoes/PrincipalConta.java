package excessoes;

import excessoes.modelo.Conta;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalConta {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.println("Entre com os dados da conta: ");
            System.out.print("Número: ");
            Integer numero = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Titular: ");
            String titular = scanner.nextLine();
            System.out.print("Saldo inicial: ");
            BigDecimal saldoInicial = scanner.nextBigDecimal();
            System.out.print("Limite saque: ");
            BigDecimal limiteSaque = scanner.nextBigDecimal();
            Conta conta = new Conta(numero, titular, saldoInicial, limiteSaque);
        }
    }

}
