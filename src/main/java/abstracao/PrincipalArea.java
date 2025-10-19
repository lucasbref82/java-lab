package abstracao;

import abstracao.entidades.Circulo;
import abstracao.entidades.Forma;
import abstracao.entidades.Retangulo;
import abstracao.enums.Cor;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalArea {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.print("Digite o número de formas: ");
            int n = scanner.nextInt();
            List<Forma> formas = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                System.out.println("Forma #" + i + " dados:");
                System.out.print("Retangulo ou Circulo (r/c): ");
                char decisao = scanner.next().charAt(0);
                System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
                Cor cor = Cor.valueOf(scanner.next());
                if (decisao == 'r') {
                    System.out.print("Largura: ");
                    BigDecimal largura = scanner.nextBigDecimal();
                    System.out.print("Altura: ");
                    BigDecimal altura = scanner.nextBigDecimal();
                    formas.add(new Retangulo(cor, largura, altura));
                } else {
                    System.out.print("Raio: ");
                    BigDecimal raio = scanner.nextBigDecimal();
                    formas.add(new Circulo(cor, raio));
                }
            }
            System.out.println();
            System.out.println("Área das formas: ");
            for(Forma forma : formas) {
                System.out.println(forma.area());
            }
        }
    }
}
