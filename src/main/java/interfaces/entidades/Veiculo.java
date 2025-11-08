package interfaces.entidades;

import java.util.Objects;

public class Veiculo {
    private String nome;

    public Veiculo() {
    }

    public Veiculo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public String nome;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Veiculo build() {
            return new Veiculo(nome);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(nome, veiculo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
