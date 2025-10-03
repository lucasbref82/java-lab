package orientacao_objetos.retangulo;

import orientacao_objetos.model.Retangulo;

import java.util.Locale;
import java.util.Scanner;

public class MedidasRetangulo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Digite a largura e a altura do retangulo: ");
            double largura = scanner.nextDouble();
            double altura = scanner.nextDouble();
            Retangulo retangulo = new Retangulo(largura, altura);
            System.out.printf("AREA = %.2f%n", retangulo.area());
            System.out.printf("PERIMETRO = %.2f%n", retangulo.perimetro());
            System.out.printf("DIAGONAL = %.2f%n", retangulo.diagonal());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao calcular as medidas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
