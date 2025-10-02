package orientacao_objetos;

import orientacao_objetos.model.Triangulo;

import java.util.Locale;
import java.util.Scanner;

public class AreaTrianguloComOO {
    public static void main(String[] args) {
        Triangulo trianguloX = new Triangulo();
        Triangulo trianguloY = new Triangulo();

        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entre com os dados do triangulo X: ");
            trianguloX.a = scanner.nextDouble();
            trianguloX.b = scanner.nextDouble();
            trianguloX.c = scanner.nextDouble();

            System.out.println("Entre com os dados do triangulo Y: ");
            trianguloY.a = scanner.nextDouble();
            trianguloY.b = scanner.nextDouble();
            trianguloY.c = scanner.nextDouble();

            double areaX = trianguloX.CalculaArea();
            double areaY = trianguloY.CalculaArea();

            System.out.printf("Área do triangulo X: %.4f\n", areaX);
            System.out.printf("Área do triangulo Y: %.4f\n", areaY);

            printaMaiorArea(areaX, areaY);

        }
    }

    private static void printaMaiorArea(double x, double y) {
        if (x > y) {
            System.out.println("Maior área X");
        } else {
            System.out.println("Maior área Y");
        }
    }
}
