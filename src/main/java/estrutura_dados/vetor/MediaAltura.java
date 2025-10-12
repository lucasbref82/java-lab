package estrutura_dados.vetor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.util.Locale;
import java.util.Scanner;

public class MediaAltura {

    private static final Logger log = LoggerFactory.getLogger(MediaAltura.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Quer calcular a altura de quantas pessoas? ");
            int n = scanner.nextInt();
            double[] alturas = new double[n];
            for (int i = 0; i < n ; i ++) {
                System.out.print(Utils.format("Digite a altura da {} pessoa: ", (i + 1)));
                alturas[i] = scanner.nextDouble();
            }
            double soma = 0;
            for (int i = 0; i < alturas.length; i++ ) {
                soma += alturas[i];
            }
            double media = soma / n;
            System.out.println(Utils.format("A média das pessoas é de: {}", media));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


}
