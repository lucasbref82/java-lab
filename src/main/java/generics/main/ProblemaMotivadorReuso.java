package generics.main;

import generics.service.PrintServiceMotivadorReuso;

import java.util.Scanner;

public class ProblemaMotivadorReuso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintServiceMotivadorReuso printServiceMotivadorReuso = new PrintServiceMotivadorReuso();
        System.out.print("Quantos valores ?");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            printServiceMotivadorReuso.adicionaValor(scanner.nextInt());
        }


    }
}
