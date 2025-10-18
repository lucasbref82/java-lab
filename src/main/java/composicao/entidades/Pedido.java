package composicao.entidades;

import enums.StatusPedido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private LocalDateTime momento;
    private StatusPedido statusPedido;
    private List<ItemPedido> itemPedidoList = new ArrayList<>();
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(LocalDateTime momento, StatusPedido statusPedido, Cliente cliente) {
        this.momento = momento;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemPedido(ItemPedido pedido) {
        itemPedidoList.add(pedido);
    }

    public void removeItemPedido(ItemPedido pedido){
        itemPedidoList.remove(pedido);
    }

    public BigDecimal total() {
        return itemPedidoList.
                stream()
                .map(ItemPedido::subTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Pedido pedido = (Pedido) object;
        return Objects.equals(momento, pedido.momento) && statusPedido == pedido.statusPedido && Objects.equals(itemPedidoList, pedido.itemPedidoList) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(momento, statusPedido, itemPedidoList, cliente);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Momento do pedido: ").append(momento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append("\n");
        stringBuilder.append("Status do pedido: ").append(statusPedido).append("\n");
        stringBuilder.append("Cliente: ").append(cliente.getNome()).append(" ").append(cliente.getDataAniversario().format(DateTimeFormatter.ofPattern("dd/MM/yyy"))).append(" - ").append(cliente.getEmail()).append("\n");
        stringBuilder.append("Itens do pedido: \n");
        int itemPedidoSize = itemPedidoList.size();
        int count = 0;
        for (ItemPedido i : itemPedidoList) {
            stringBuilder.append(i.getProduto().getNome()).append(", Quantidade: ").append(i.getQuantidade()).append(", Subtotal: ").append("$").append(i.subTotal().setScale(2, RoundingMode.HALF_UP)).append(itemPedidoSize != count ? "\n" : null);
            ++count;
        }
        stringBuilder.append(total());
        return stringBuilder.toString();
    }
}
