package orientacao_objetos.controle_estoque;

import orientacao_objetos.model.Produto;

import java.util.Locale;
import java.util.Scanner;

public class ControleDeEstoqueEncapsulado {
    public static void main(String[] args) {
        Produto produto = new Produto();
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Entre com os dados do produto: ");

            System.out.print("Nome: ");
            produto.setNome(scanner.next());

            System.out.print("Preço: ");
            produto.setPreco(scanner.nextDouble());

            System.out.print("Quantidade em estoque: ");
            produto.adicionarProdutoNoEstoque(scanner.nextInt());
            System.out.println();

            System.out.println("Dados do produto: " + produto);
            System.out.println();

            System.out.print("Digite a quantidade de produtos que quer adicionar no estoque: ");
            produto.adicionarProdutoNoEstoque(scanner.nextInt());
            System.out.println();

            System.out.println("Produto atualizado: " + produto);
            System.out.println();

            System.out.print("Digite a quantidade de produtos que deseja remover do estoque: ");
            produto.removerProdutoNoEstique(scanner.nextInt());
            System.out.println();

            System.out.println("Produto atualizado: " + produto);
            System.out.println();
        }
    }
}
