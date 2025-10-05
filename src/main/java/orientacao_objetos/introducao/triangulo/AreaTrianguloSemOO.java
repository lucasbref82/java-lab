package orientacao_objetos.introducao.triangulo;

import java.util.Locale;
import java.util.Scanner;

public class AreaTrianguloSemOO {
    public static void main(String[] args) {
        double xA, xB, xC, yA, yB, yC;
        Locale.setDefault(Locale.US);
        /*
        Não fechar Scanner = vazamento de recursos (Ocupa recursos podendo causar bloqueios em arquivos)
        Possível bloqueio de arquivo
        Problemas em aplicações de longa execução.
        */
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entre com os dados do triangulo X: ");
            xA = scanner.nextDouble();
            xB = scanner.nextDouble();
            xC = scanner.nextDouble();
            System.out.println("Entre com os dados do triangulo Y: ");
            yA = scanner.nextDouble();
            yB = scanner.nextDouble();
            yC = scanner.nextDouble();

            double p = (xA + xB + xC) / 2;
            double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

            p = (yA + yB + yC) / 2;
            double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

            System.out.printf("Área do triangulo X: %.4f\n", areaX);
            System.out.printf("Área do triangulo Y: %.4f\n", areaY);

            if (areaX > areaY) {
                System.out.println("Maior área X");
            } else {
                System.out.println("Maior área Y");
            }
        }
    }
}
