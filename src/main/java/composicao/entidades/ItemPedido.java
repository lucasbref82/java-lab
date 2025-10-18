package composicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class ItemPedido {

    private Integer quantidade;
    private BigDecimal preco;
    private Produto produto;


    private ItemPedido(Builder builder) {
        this.quantidade = builder.quantidade;
        this.preco = builder.preco;
        this.produto = builder.produto;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigDecimal subTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    public static final class Builder {
        private Integer quantidade;
        private BigDecimal preco;
        private Produto produto;

        private Builder() {}

        public Builder quantidade(Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder produto(Produto produto) {
            this.produto = produto;
            return this;
        }

        public ItemPedido build() {
            Objects.requireNonNull(quantidade, "Quantidade não pode ser nula.");
            Objects.requireNonNull(produto, "Produto não pode ser nulo.");
            return new ItemPedido(this);
        }
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
