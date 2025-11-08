package excessoes;

import excessoes.modelo.ReservaHotel;
import utils.TimeUtils;
import utils.Utils;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalReserva {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            System.out.print("Número do quarto: ");
            Integer numeroQuarto = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Data de entrada (DD/MM/YYYY): ");
            String dataEntrada = scanner.nextLine();
            System.out.print("Data de saída (DD/MM/YYYY): ");
            String dataSaida = scanner.nextLine();
            ReservaHotel reservaHotel =
                    new ReservaHotel(
                            numeroQuarto,
                            TimeUtils.parserLocalDate(dataEntrada, TimeUtils.LOCAL_DATE_PT_BR),
                            TimeUtils.parserLocalDate(dataSaida, TimeUtils.LOCAL_DATE_PT_BR)
                    );
            System.out.println(reservaHotel);

            System.out.println();

            System.out.println("Digite a data para atualizar a reserva: ");
            System.out.print("Data de entrada (DD/MM/YYYY): ");
            dataEntrada = scanner.nextLine();
            System.out.print("Data de saída (DD/MM/YYYY): ");
            dataSaida = scanner.nextLine();
            reservaHotel.atualizarDatas(TimeUtils.parserLocalDate(dataEntrada, TimeUtils.LOCAL_DATE_PT_BR), TimeUtils.parserLocalDate(dataSaida, TimeUtils.LOCAL_DATE_PT_BR));
            System.out.println(reservaHotel);
        } catch (Exception e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
    }
}
