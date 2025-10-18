package polimorfismo.entidades;

import lombok.Getter;
import lombok.Setter;
import utils.Utils;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class ProdutoImportado extends Produto{

    private BigDecimal taxaImportacao;

    public ProdutoImportado(String nome, BigDecimal preco, BigDecimal taxaImportacao) {
        super(nome, preco);
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public String tagPreco() {
        return Utils.format("{} $ {} (Taxa de Importação: {})", nome, preco, taxaImportacao);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ProdutoImportado that = (ProdutoImportado) object;
        return Objects.equals(taxaImportacao, that.taxaImportacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taxaImportacao);
    }
}
