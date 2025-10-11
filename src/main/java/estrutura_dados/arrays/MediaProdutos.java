package estrutura_dados.arrays;

import estrutura_dados.model.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class MediaProdutos {

    private static final Logger log = LoggerFactory.getLogger(MediaProdutos.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Digite a quantidade de produtos a serem armazenados.");
            int n = scanner.nextInt();
            Produto[] produtos = new Produto[n];
            for(int i = 0; i < n; i++) {
                System.out.println("Digite os dados do produto!");
                System.out.print("Nome: ");
                scanner.nextInt();
                String nome = scanner.nextLine();
                System.out.print("Preço: ");
                BigDecimal preco = scanner.nextBigDecimal();
                produtos[i] = new Produto(nome, preco);
            }
            BigDecimal precoProdutos = Arrays.stream(produtos)
                    .map(Produto::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal media = precoProdutos.divide(BigDecimal.valueOf(n), RoundingMode.HALF_UP);

            System.out.println(Utils.format("A média dos produtos é : {}", media));
        } catch (Exception e) {
            log.error("Aconteceu um erro ao fazer a operação.", e);
        }
    }
}
