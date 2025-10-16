package composicao.enums;

public enum StatusPedido {
    PAGAMENTO_PENDENTE("Pagamento Pendente"),
    PROCESSANDO("Processando"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue");

    StatusPedido(String nome) {
        this.nome = nome;
    }

    private String nome;

    public String getNome() {
        return nome;
    }
}
