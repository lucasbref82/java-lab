package polimorfismo.entidades;

import lombok.Getter;
import lombok.Setter;
import utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
public class ProdutoUsado extends Produto{

    private LocalDate dataFabricacao;

    public ProdutoUsado() {
        super();
    }

    public ProdutoUsado(String nome, BigDecimal preco, LocalDate dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String tagPreco() {
        return Utils.format("{} (usado) $ {} (Data de Fabricacao: {})", nome, preco, dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ProdutoUsado that = (ProdutoUsado) object;
        return Objects.equals(dataFabricacao, that.dataFabricacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataFabricacao);
    }
}
