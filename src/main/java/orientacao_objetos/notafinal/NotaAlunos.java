package orientacao_objetos.notafinal;

import orientacao_objetos.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class NotaAlunos {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Double> notas = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            String nome = scanner.nextLine();
            double n1 = scanner.nextDouble();
            double n2 = scanner.nextDouble();
            double n3 = scanner.nextDouble();
            notas.addAll(List.of(n1, n2, n3));
            Aluno aluno = new Aluno(nome, notas);
            System.out.println(aluno.printaNotaFinal());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro no sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
