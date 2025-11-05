package interfaces;

import interfaces.entidades.Estacionamento;
import utils.TimeUtils;

import java.util.Scanner;

public class EstacionamentoMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Modelo do carro: ");
            String modeloCarro = scanner.nextLine();
            System.out.print("Entrada (dd/MM/yyyy hh:mm): ");
            String dataEntrada = scanner.nextLine();
            System.out.print("(Data saída (dd/MM/yyyy hh:mm): ");
            String dataSaida = scanner.nextLine();
            Estacionamento estacionamento = new Estacionamento(modeloCarro, TimeUtils.parserLocalDateTimeBr(dataEntrada), TimeUtils.parserLocalDateTimeBr(dataSaida));

        }
    }
}
