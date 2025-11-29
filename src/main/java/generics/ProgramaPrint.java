package generics;

import generics.service.PrintService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramaPrint {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Quantos números vão ser digitados? ");
            int n = scanner.nextInt();
            PrintService<Integer> printService = new PrintService<>();
            for (int i = 0; i < n; i++) {
                int numb = scanner.nextInt();
                printService.add(numb);
            }
            printService.imprime();
            System.out.println("Primeiro: " + printService.primeiro());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar a aplicação: " + e.getMessage());
        }
    }
}
