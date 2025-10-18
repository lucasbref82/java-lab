package polimorfismo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polimorfismo.entidades.Produto;
import polimorfismo.entidades.ProdutoImportado;
import polimorfismo.entidades.ProdutoUsado;
import utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalProduto {
    private static final Logger log = LoggerFactory.getLogger(PrincipalProduto.class);

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            scanner.useLocale(Locale.US);
            System.out.print("Digite a quantidade de produtos: ");
            Integer quantidade = scanner.nextInt();
            scanner.nextLine();
            List<Produto> produtos = new ArrayList<>();
            for (int i = 1; i <= quantidade; i++) {
                scanner.nextLine();
                System.out.println("Dados do produto #" + i);
                System.out.print("Comum, usado ou importado (c/u/i)? ");
                char tipoProduto = scanner.nextLine().charAt(0);
                System.out.print("Nome: ");
                String nome = scanner.nextLine().trim();
                System.out.print("Preco: ");
                BigDecimal preco = scanner.nextBigDecimal();
                if (tipoProduto == 'i') {
                    System.out.print("Taxa de importação: ");
                    BigDecimal taxaImportacao = scanner.nextBigDecimal();
                    produtos.add(new ProdutoImportado(nome, preco, taxaImportacao));
                } else if (tipoProduto == 'u') {
                    scanner.nextLine();
                    System.out.print("Data de fabricação (DD/MM/YYYY): ");
                    String dataString = scanner.nextLine().trim();
                    LocalDate dataFabricacao = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
                } else {
                    produtos.add(new Produto(nome, preco));
                }
            }

            System.out.println();
            System.out.println("TAGS DE PREÇO: ");
            for (Produto produto : produtos) {
                System.out.println(produto.tagPreco());
            }

        } catch (Exception e) {
            log.error(Utils.format("Ocorreu um erro ao executar o programa: {}", e.getMessage()), e);
        }
    }
}
