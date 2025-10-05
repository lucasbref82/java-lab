package orientacao_objetos.estaticos;

import orientacao_objetos.estaticos.utils.CalculadoraUtils;

import java.util.Locale;
import java.util.Scanner;

public class EstaticoBom {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Digite o raio: ");
            double raio = scanner.nextDouble();
            double circunferencia = CalculadoraUtils.calculaCircunferencia(raio);
            double volume = CalculadoraUtils.calculaVolume(raio);
            System.out.printf("Circunferencia: %.2f%n", circunferencia);
            System.out.printf("Volume: %.2f%n", volume);
            System.out.printf("PI: %.2f%n", CalculadoraUtils.PI);
        }

    }
}
