package arquivo.exercicio.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal calculaValorTotal() {
        return valor.multiply(new BigDecimal(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(valor, produto.valor) && Objects.equals(quantidade, produto.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valor, quantidade);
    }
}
