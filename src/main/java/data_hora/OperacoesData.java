package data_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OperacoesData {

    public static void main(String[] args) {
        LocalDate d1 = LocalDate.now(); // Data Local
        LocalDateTime d2 = LocalDateTime.now(); // Data e Hora local
        Instant d3 = Instant.now(); // Sempre usa o padrão GMT
        LocalDate d4 = LocalDate.parse("2022-07-20"); // Pegando uma string com uma data no padrão ISO 8601 e transformando em LocalDate
        LocalDateTime d5 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d6 = Instant.parse("2022-07-20T01:30:26Z"); // Gera a data hora em string em um horário de Londres.
        Instant d7 = Instant.parse("2022-07-20T01:30:26-03:00"); // Recupera uma String no no formato de londes e dimunui a quantidade de horas necessárias para entrar no padrão America/São Paulo

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
    }
}
