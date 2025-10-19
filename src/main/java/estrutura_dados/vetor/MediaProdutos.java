package estrutura_dados.vetor;

import estrutura_dados.entidades.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MediaProdutos {

    private static final Logger log = LoggerFactory.getLogger(MediaProdutos.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            System.out.println("Digite a quantidade de produtos a serem armazenados.");
            int n = scanner.nextInt();
            scanner.nextLine();

            if (n <= 0) {
                System.out.println("Quantidade inválida (deve ser maior que zero).");
                return;
            }

            Produto[] produtos = new Produto[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Digite os dados do produto!");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Preço: ");
                BigDecimal preco = scanner.nextBigDecimal();
                scanner.nextLine();

                produtos[i] = new Produto(nome, preco);
            }

            BigDecimal precoProdutos = Arrays.stream(produtos)
                    .map(Produto::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal media = precoProdutos.divide(BigDecimal.valueOf(n), 2, RoundingMode.HALF_UP);

            System.out.println(Utils.format("A média dos produtos é : {}", media));
        } catch (Exception e) {
            log.error(Utils.format("Aconteceu um erro ao fazer a operação : {}", e.getMessage()), e);
        }
    }
}
