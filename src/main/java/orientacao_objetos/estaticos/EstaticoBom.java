package orientacao_objetos.estaticos;

import java.util.Locale;
import java.util.Scanner;

public class EstaticoMediano {
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
}
