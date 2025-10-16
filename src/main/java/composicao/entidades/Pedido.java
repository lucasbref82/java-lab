package composicao.entidades;

import enums.StatusPedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private LocalDate momento;
    private StatusPedido statusPedido;
    private List<ItemPedido> itemPedidoList = new ArrayList<>();
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(LocalDate momento, StatusPedido statusPedido, Cliente cliente) {
        this.momento = momento;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
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

    public void removePedido(ItemPedido pedido){
        itemPedidoList.remove(pedido);
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
}
