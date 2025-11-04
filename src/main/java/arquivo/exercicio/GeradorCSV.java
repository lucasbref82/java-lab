package arquivo.exercicio;

import arquivo.exercicio.entidades.Produto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GeradorCSV {
    public static void main(String[] args) {
        String pasta = "c:\\temp\\entrada.txt";
        Path entrada = Paths.get(pasta);

        if (!Files.exists(entrada)) {
            System.out.println("Arquivo de entrada não encontrado: " + entrada.toAbsolutePath());
            return;
        }

        Path outDir = entrada.getParent().resolve("out");
        try {
            Files.createDirectories(outDir);
        } catch (IOException e) {
            System.out.println("Erro ao criar diretório de saída: " + e.getMessage());
            return;
        }

        Path arquivoSaida = outDir.resolve("sumario.csv");

        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(entrada)) {
            String linha = br.readLine();
            while (linha != null) {
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(",");

                String nome = partes[0].trim();

                String precoStr = partes[1].trim().replace(",", ".");

                BigDecimal preco = new BigDecimal(precoStr);

                int quantidade = Integer.parseInt(partes[2].trim());

                produtos.add(new Produto(nome, preco, quantidade));

                linha = br.readLine();

            }
        } catch (Exception e) {
            System.out.println("Erro lendo arquivo de entrada: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = Files.newBufferedWriter(arquivoSaida)) {
            for (Produto p : produtos) {
                String linhaCsv = String.format(Locale.US, "%s,%.2f", p.getNome(), p.calculaValorTotal());
                bw.write(linhaCsv);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro escrevendo CSV: " + e.getMessage());
            return;
        }
        System.out.println("CSV gerado em: " + arquivoSaida.toAbsolutePath());
    }
}
