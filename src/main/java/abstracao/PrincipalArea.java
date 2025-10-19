package abstracao;

import java.util.Locale;
import java.util.Scanner;

public class PrincipalArea {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

        }
    }
}
