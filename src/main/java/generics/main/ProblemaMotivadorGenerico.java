package generics.main;

import generics.service.PrintServiceGenerico;

import java.util.Locale;
import java.util.Scanner;

public class ProblemaMotivadorGenerico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        PrintServiceGenerico<String> printServiceGenerico = new PrintServiceGenerico<>();
        System.out.print("Quantos valores? ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String valor = scanner.next();
            printServiceGenerico.add(valor);
        }
        printServiceGenerico.imprime();
        System.out.println("Primeiro: " + printServiceGenerico.primeiro());
    }
}
