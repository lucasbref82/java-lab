package orientacao_objetos.model;

import java.util.List;
import java.util.Locale;

public class Aluno {

    private String nome;
    private List<Double> notas;
    private static final int FATOR_APROVACAO = 60;

    public Aluno(String nome, List<Double> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public String printaNotaFinal() {
        double notaFinal = (notas == null || notas.isEmpty())
                        ? 0.0
                        : notas.stream().mapToDouble(Double::doubleValue).sum();

        boolean aprovado = notaFinal >= FATOR_APROVACAO;

        if (aprovado) {
            return String.format(Locale.US, "Nota final = %.2f%nAprovado", notaFinal);
        }

        double pontosFaltantes = Math.max(0.0, FATOR_APROVACAO - notaFinal);

        return String.format(Locale.US, "Nota final = %.2f%nReprovado%nFaltaram %.2f pontos",
                notaFinal, pontosFaltantes);
    }
}
