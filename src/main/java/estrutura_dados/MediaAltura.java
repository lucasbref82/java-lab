package estrutura_dados;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MediaAltura {
    private static final Logger log = LoggerFactory.getLogger(MediaAltura.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Quer calcular a altura de quantas pessoas? ");
            int n = scanner.nextInt();
            BigDecimal[] somaAlturas = new BigDecimal[n];
            for (int i = 0; i < n ; i ++) {
                System.out.print(Utils.format("Digite a altura da {} pessoa: ", (i + 1)));
                BigDecimal alturaPessoa = scanner.nextBigDecimal();
                somaAlturas[i] = alturaPessoa;
            }
            BigDecimal media =
                    Arrays.stream(somaAlturas)
                            .reduce(BigDecimal.ZERO, BigDecimal::add).
                            divide(new BigDecimal(n), RoundingMode.HALF_UP);
            System.out.println(Utils.format("A média das pessoas é de: {}", media));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


}
