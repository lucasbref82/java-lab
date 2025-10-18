package composicao.principal;

import composicao.entidades.Cliente;
import composicao.entidades.ItemPedido;
import composicao.entidades.Pedido;
import composicao.entidades.Produto;
import enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalPedido {
    private static final DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            System.out.println("Digite os dados do cliente:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Digite o e-mail: ");
            String email = scanner.nextLine().trim();

            System.out.print("Data de aniversário (DD/MM/YYYY): ");
            String dataString = scanner.nextLine().trim();
            LocalDate dataAniversario = LocalDate.parse(dataString, DATA);

            Cliente cliente = new Cliente(nome, email, dataAniversario);

            System.out.println("\nDigite os dados do pedido:");
            System.out.print("Status do pedido: ");
            String statusRaw = scanner.nextLine().trim().toUpperCase();
            StatusPedido statusPedido = StatusPedido.valueOf(statusRaw);

            System.out.print("Quantos itens vai ter no pedido? ");
            int quantidadeItems = Integer.parseInt(scanner.nextLine().trim());

            Pedido pedido = new Pedido(LocalDateTime.now(), statusPedido, cliente);

            for (int i = 1; i <= quantidadeItems; i++) {
                System.out.println("\nDigite os dados do item #" + i + ":");

                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.nextLine().trim();

                System.out.print("Preço: ");
                String precoStr = scanner.nextLine().trim().replace(',', '.'); // Aceita , e .
                BigDecimal precoProduto = new BigDecimal(precoStr);

                System.out.print("Quantidade: ");
                int quantidadeProduto = Integer.parseInt(scanner.nextLine().trim());

                ItemPedido itemPedido = ItemPedido.builder()
                        .quantidade(quantidadeProduto)
                        .preco(precoProduto)
                        .produto(new Produto(nomeProduto, precoProduto)).
                        build();

                pedido.addItemPedido(itemPedido);
            }

            System.out.println("\nResumo do pedido:");
            System.out.println(pedido);

        } catch (IllegalArgumentException e) {
            System.err.println("Entrada inválida: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao realizar a operação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
