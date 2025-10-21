package abstracao;

import abstracao.entidades.Pessoa;
import abstracao.entidades.PessoaFisica;
import abstracao.entidades.PessoaJuridica;
import lombok.extern.slf4j.Slf4j;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class PrincipalPessoa {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            System.out.print("Digite o número de pagadores de impostos: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Pessoa> pessoas = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                System.out.println("Dados do pagador de imposto #" + i);

                System.out.print("Pessoa física ou jurídica (f/j)? ");
                char tipoPessoa = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();

                System.out.print("Nome: ");
                String nome = scanner.nextLine().trim();

                System.out.print("Renda anual: ");
                BigDecimal rendaAnual = scanner.nextBigDecimal();

                if (tipoPessoa == 'f') {
                    System.out.print("Gastos com saúde: ");
                    BigDecimal gastosSaude = scanner.nextBigDecimal();
                    pessoas.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
                } else {
                    System.out.print("Quantidade de funcionários: ");
                    int quantidadeFuncionarios = scanner.nextInt();
                    pessoas.add(new PessoaJuridica(nome, rendaAnual, quantidadeFuncionarios));
                }
                scanner.nextLine();
            }

            System.out.println();
            System.out.println("IMPOSTOS PAGOS:");
            BigDecimal somaTotalImpostos = BigDecimal.ZERO;

            for (Pessoa pessoa : pessoas) {
                BigDecimal imposto = pessoa.calculaImposto();
                System.out.println(Utils.format("{}: $ {}", pessoa.getNome(), imposto.setScale(2, RoundingMode.HALF_UP)));
                somaTotalImpostos = somaTotalImpostos.add(imposto);
            }

            System.out.println();
            System.out.println(Utils.format("TOTAL DE IMPOSTOS: $ {}", somaTotalImpostos.setScale(2, RoundingMode.HALF_UP)));
        } catch (Exception e) {
            log.error("Ocorreu um erro ao executar o programa : {}", e.getMessage(), e);
        }
    }
}
