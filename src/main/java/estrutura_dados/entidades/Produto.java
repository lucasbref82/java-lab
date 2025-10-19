package estrutura_dados.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto() {

    }

    public Produto(String nome, BigDecimal preco) {
        trataNomeNulo(nome);
        trataPrecoNuloOuMenorIgualZero(preco);
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        trataNomeNulo(nome);
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        trataPrecoNuloOuMenorIgualZero(preco);
        this.preco = preco;
    }

    private void trataNomeNulo(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo.");
    }

    private void trataPrecoNuloOuMenorIgualZero(BigDecimal preco) {
        Objects.requireNonNull(nome, "Preço não pode ser nulo.");
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preco do produto não pode ser menor ou igual a zero");
        }

    }
}
