package arquivo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LerArquivoScanner {

    public static void main(String[] args) {
        File file = new File("c:\\temp\\entrada.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e1) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e1.getMessage());
        }
    }
}
