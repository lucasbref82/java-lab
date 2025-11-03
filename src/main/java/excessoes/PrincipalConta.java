package excessoes;

import excessoes.modelo.Conta;
import excessoes.modelo.excessao.RegraNegocioException;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
            System.out.println();
            System.out.print("Digite o valor de saque: ");
            BigDecimal valorSaque = scanner.nextBigDecimal();
            conta.sacar(valorSaque);
            System.out.print("Novo saldo: "+ conta.getSaldo().setScale(2, RoundingMode.HALF_UP));
        } catch (RegraNegocioException e1) {
            System.out.println("Erro no saque: " + e1.getMessage());
        } catch (Exception e2) {
            System.out.println("Erro inesperado ao tentar executar a aplicação: " + e2.getMessage());
        }
    }

}
