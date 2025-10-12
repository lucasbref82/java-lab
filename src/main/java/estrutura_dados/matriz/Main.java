package estrutura_dados.matriz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int[][] matriz = new int[n][n];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Diagonal principal: ");
            for (int i = 0; i < n; i ++) {
                System.out.println(matriz[i][i]);
            }
            System.out.println();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matriz[i][j] < 0) {
                        count++;
                    }
                }
            }
            System.out.println(Utils.format("Números negativos: {}", count));
        } catch (Exception e) {
            log.error(Utils.format("Aconteceu um erro no programa: {}", e.getMessage()), e);
        }
    }
}
