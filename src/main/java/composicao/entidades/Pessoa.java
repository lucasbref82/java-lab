package composicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    protected String nome;
    protected LocalDate dataAniversario;
    protected String cpf;
    protected String registroGeral;
    protected String cor;
    protected String nacionalidade;

    public Pessoa(String nome, LocalDate dataAniversario) {
        this.nome = nome;
        this.dataAniversario = dataAniversario;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Pessoa pessoa = (Pessoa) object;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataAniversario, cpf, registroGeral, cor, nacionalidade);
    }
}
