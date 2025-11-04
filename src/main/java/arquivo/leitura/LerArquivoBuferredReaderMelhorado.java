package arquivo.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoBuferredReaderMelhorado {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("c:\\temp\\entrada.txt"))) {
            String linha = bufferedReader.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }
        } catch (IOException e1) {
            System.out.println("Erro ao executar o programa: ");
        }
    }
}
