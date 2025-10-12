package composicao.principal;

import composicao.entidades.Departamento;
import composicao.entidades.HoraContrato;
import composicao.entidades.Trabalhador;
import composicao.enums.Senioridade;
import lombok.extern.slf4j.Slf4j;
import utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class Principal {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.print("Qual o nome do departamento?");
            String nomeDepartamento = scanner.nextLine();
            Departamento departamento = new Departamento(nomeDepartamento);
            System.out.println("Entre com os dados do trabalhador: ");
            System.out.print("Nome: ");
            String nomeTrabalhador = scanner.nextLine();
            System.out.print("Senioridade: ");
            Senioridade senioridade = Senioridade.valueOf(scanner.nextLine());
            System.out.print("Salário base: ");
            BigDecimal salarioBase = scanner.nextBigDecimal();
            System.out.print("Quantos contratos tem esse trabalhador ?");
            Integer quantidadeContratos = scanner.nextInt();
            List<HoraContrato> horaContratos = new ArrayList<>();
            for (int i = 1; i <= quantidadeContratos; i++) {
                System.out.println("Entre com os dados do contradto #" + i);
                System.out.print("Data (DD/MM/YYYY): ");
                LocalDateTime dataContrato = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.print("Valor por hora: ");
                BigDecimal valorPorHora = scanner.nextBigDecimal();
                System.out.print("Duração (Horas): ");
                Integer duracaoContrato = scanner.nextInt();
                horaContratos.add(new HoraContrato(dataContrato, valorPorHora, duracaoContrato));
            }
            Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, senioridade, salarioBase, horaContratos, departamento);
            System.out.println();
            System.out.print("Digite os dados para calcular a renda (MM/YYYY");
            String mesRenda = scanner.nextLine();
        } catch (Exception e) {
            log.error(Utils.format("Aconteceu um erro ao executar o programa: {}", e.getMessage()), e);
        }
    }
}
