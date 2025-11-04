package arquivo;

import java.io.File;
import java.util.Scanner;

public class Pastas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho da pasta: ");
        String caminhoPasta = scanner.nextLine();
        File pasta = new File(caminhoPasta);

        File[] pastas = pasta.listFiles(File::isDirectory);
        System.out.println("Pastas: ");
        for (File file : pastas) {
            System.out.println(file);
        }


        System.out.println();

        File[] arquivos = pasta.listFiles(File::isFile);
        System.out.println("Arquivos: ");
        for (File arquivo : arquivos) {
            System.out.println(arquivo);
        }

        boolean sucesso = new File(caminhoPasta + "\\subdiretorio").mkdir();

        System.out.println("Diretório foi criado com sucesso? " + sucesso);
    }
}
