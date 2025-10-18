package composicao.entidades;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Departamento {
    private String nome;

    public Departamento(Builder builder) {
        this.nome = builder.nome;
    }

    private static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String nome;

        private Builder() {

        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Departamento build() {
            Objects.requireNonNull(nome, "Nome não pode ser nulo.");
            return new Departamento(this);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Departamento that = (Departamento) object;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
