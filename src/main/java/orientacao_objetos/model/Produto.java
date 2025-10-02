package orientacao_objetos.model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    public void adicionarProdutoNoEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerProdutoNoEstique(int quantidade) {
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return nome + ", $ " + String.format("%.2f", preco) + ", " + quantidade + " unidades, " + "Total: $" + String.format("%.2f", valorTotalEmEstoque());
    }
}
