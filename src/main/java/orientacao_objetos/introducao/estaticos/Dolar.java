package orientacao_objetos.introducao.estaticos;

import orientacao_objetos.introducao.estaticos.utils.ConversorUtils;

import java.util.Locale;
import java.util.Scanner;

public class Dolar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Qual é o preço do dolar ? ");
            double valorDolar = scanner.nextDouble();
            System.out.print("Quantos dólares você quer converter ? ");
            double quantidadeDolar = scanner.nextDouble();
            System.out.printf("Quantidade a ser paga em reais = %.2f", ConversorUtils.conversorDolarEmReais(valorDolar, quantidadeDolar));
        }
    }
}
