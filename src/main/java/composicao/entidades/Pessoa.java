package composicao.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
    protected String nome;
    protected LocalDate dataAniversario;
    protected String cpf;
    protected String registroGeral;
    protected String cor;
    protected String nacionalidade;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataAniversario, String cpf, String registroGeral, String cor, String nacionalidade) {
        this.nome = nome;
        this.dataAniversario = dataAniversario;
        this.cpf = cpf;
        this.registroGeral = registroGeral;
        this.cor = cor;
        this.nacionalidade = nacionalidade;
    }

    public Pessoa(String nome, LocalDate dataAniversario) {
        this.nome = nome;
        this.dataAniversario = dataAniversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Pessoa pessoa = (Pessoa) object;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(dataAniversario, pessoa.dataAniversario) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(registroGeral, pessoa.registroGeral) && Objects.equals(cor, pessoa.cor) && Objects.equals(nacionalidade, pessoa.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataAniversario, cpf, registroGeral, cor, nacionalidade);
    }
}
