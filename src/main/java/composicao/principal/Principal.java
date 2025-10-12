package composicao.principal;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
        } catch (Exception e) {

        }
    }
}
