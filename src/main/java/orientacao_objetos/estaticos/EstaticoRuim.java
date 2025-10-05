package orientacao_objetos.estaticos;

import java.util.Locale;
import java.util.Scanner;

public class EstaticoRuim {

    private static final double PI = 3.14159;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Digite o raio: ");
            double raio = scanner.nextDouble();
            double circunferencia = calculaCircunferencia(raio);
            double volume = calculaVolume(raio);
            System.out.printf("Circunferencia: %.2f%n", circunferencia);
            System.out.printf("Volume: %.2f%n", volume);
            System.out.printf("PI: %.2f%n", PI);
        }

    }
    public static double calculaCircunferencia(double raio) {
        return 2 * PI * raio;
    }

    public static double calculaVolume(double raio) {
        return 4.0 * PI * raio * raio * raio / 3.0;
    }
}
