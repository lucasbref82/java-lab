package composicao.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemPedido {
    private Integer quantidade;
    private BigDecimal preco;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, BigDecimal preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal subTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ItemPedido that = (ItemPedido) object;
        return Objects.equals(quantidade, that.quantidade) && Objects.equals(preco, that.preco) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantidade, preco, produto);
    }
}
