package orientacao_objetos.introducao.triangulo;

import orientacao_objetos.introducao.model.Triangulo;

import java.util.Locale;
import java.util.Scanner;

public class AreaTrianguloComOOSimples {
    public static void main(String[] args) {
        Triangulo trianguloX = new Triangulo();
        Triangulo trianguloY = new Triangulo();

        Locale.setDefault(Locale.US);
        /*
        Não fechar Scanner = vazamento de recursos (Ocupa recursos podendo causar bloqueios em arquivos)
        Possível bloqueio de arquivo
        Problemas em aplicações de longa execução.
        */
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Entre com os dados do triangulo X: ");
            trianguloX.a = scanner.nextDouble();
            trianguloX.b = scanner.nextDouble();
            trianguloX.c = scanner.nextDouble();

            System.out.println("Entre com os dados do triangulo Y: ");
            trianguloY.a = scanner.nextDouble();
            trianguloY.b = scanner.nextDouble();
            trianguloY.c = scanner.nextDouble();

            double p = (trianguloX.a + trianguloX.b + trianguloX.c) / 2;
            double areaX = Math.sqrt(p * (p - trianguloX.a) * (p - trianguloX.b) * (p - trianguloX.c));

            p = (trianguloY.a + trianguloY.b + trianguloY.c) / 2;
            double areaY = Math.sqrt(p * (p - trianguloY.a) * (p - trianguloY.b) * (p - trianguloX.c));

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
