package arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoBufferedReader {
    public static void main(String[] args) {
        String caminho = "c:\\temp\\entrada.txt";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(caminho));
            String linha = bufferedReader.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }
        } catch (IOException e1) {
            System.out.println("Erro no programa: " + e1.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e2) {
                System.out.println("Erro no programa: " + e2.getMessage());
            }

        }
    }
}
