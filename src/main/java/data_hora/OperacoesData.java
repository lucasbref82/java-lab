package data_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperacoesData {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d1 = LocalDate.now(); // Data Local
        LocalDateTime d2 = LocalDateTime.now(); // Data e Hora local
        Instant d3 = Instant.now(); // Sempre usa o padrão GMT
        LocalDate d4 = LocalDate.parse("2022-07-20"); // Pegando uma string com uma data no padrão ISO 8601 e transformando em LocalDate
        LocalDateTime d5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d6 = Instant.parse("2022-07-20T01:30:26Z"); // Gera a data hora em string em um horário de Londres.
        Instant d7 = Instant.parse("2022-07-20T01:30:26-03:00"); // Recupera uma String no no formato de londes e dimunui a quantidade de horas necessárias para entrar no padrão America/São Paulo

        LocalDate d8 = LocalDate.parse("20/07/2022", dateTimeFormatter1);
        LocalDateTime d9 = LocalDateTime.parse("20/07/2022 01:30", dateTimeFormatter2);
        LocalDate d10 = LocalDate.of(2022, 7, 12);
        LocalDateTime d11 = LocalDateTime.of(2025, 10, 12, 11, 37);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);
        System.out.println(d9);
        System.out.println(d10);
        System.out.println(d11);
    }
}
