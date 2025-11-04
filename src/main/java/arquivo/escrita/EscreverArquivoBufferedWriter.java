package arquivo.escrita;

import java.io.*;

public class EscreverArquivoBufferedWriter {
    public static void main(String[] args) {
        String[] textos = {"Lucas Brenner", "Larissa Murta", "Olívia Castro"};
        String caminho = "c:\\temp\\saida.txt";
        try (BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(caminho, true))) {
            for (String texto : textos) {
                bufferedReader.write(texto);
                bufferedReader.newLine();
            }
        } catch (IOException e1) {
            System.out.println("Erro ao executar o programa: " + e1.getMessage());
        }
    }
}
