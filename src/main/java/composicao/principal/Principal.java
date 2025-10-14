package composicao.principal;

import composicao.entidades.Departamento;
import composicao.entidades.HoraContrato;
import composicao.entidades.Trabalhador;
import composicao.enums.Senioridade;
import lombok.extern.slf4j.Slf4j;
import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            // Criação do departamento
            System.out.print("Qual o nome do departamento? ");
            String nomeDepartamento = scanner.nextLine();
            Departamento departamento = new Departamento(nomeDepartamento);

            // Trabalhador e hora contrato
            System.out.println("Entre com os dados do trabalhador: ");
            System.out.print("Nome: ");
            String nomeTrabalhador = scanner.nextLine();
            System.out.print("Senioridade: ");
            Senioridade senioridade = Senioridade.valueOf(scanner.nextLine());
            System.out.print("Salário base: ");
            BigDecimal salarioBase = scanner.nextBigDecimal();
            System.out.print("Quantos contratos tem esse trabalhador? ");
            Integer quantidadeContratos = scanner.nextInt();

            // Cria a lista de contratos e percorre por ela.
            List<HoraContrato> horaContratos = new ArrayList<>();
            for (int i = 1; i <= quantidadeContratos; i++) {
                scanner.nextLine();
                System.out.println("Entre com os dados do contrato #" + i);
                System.out.print("Data (DD/MM/YYYY): ");
                String dtContrato = scanner.nextLine();
                LocalDate dataContrato = LocalDate.parse(dtContrato, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.print("Valor por hora: ");
                BigDecimal valorPorHora = scanner.nextBigDecimal();
                System.out.print("Duração (Horas): ");
                Integer duracaoContrato = scanner.nextInt();
                horaContratos.add(new HoraContrato(dataContrato, valorPorHora, duracaoContrato));
            }

            // Cria o trabalhador com base nos dados digitados.
            Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, senioridade, salarioBase, horaContratos, departamento);
            System.out.println();


            System.out.print("Digite os dados para calcular a renda (MM/YYYY): ");
            scanner.nextLine();
            String mesRenda = scanner.nextLine();
            YearMonth anoMes = YearMonth.parse(mesRenda, DateTimeFormatter.ofPattern("MM/yyyy"));
            BigDecimal resultado = trabalhador.renda(anoMes.getYear(), anoMes.getMonthValue());
            System.out.println("Nome: " + trabalhador.getNome());
            System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
            System.out.println("Renda de " + mesRenda + ": " + resultado.setScale(2, RoundingMode.HALF_UP));
        } catch (Exception e) {
            log.error(Utils.format("Aconteceu um erro ao executar o programa: {}", e.getMessage()), e);
        }
    }
}
