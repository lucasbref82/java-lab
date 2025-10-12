package enums.entidades;

import enums.StatusPedido;

import java.time.LocalDateTime;

public class Pedido {

    private Integer id;
    private LocalDateTime horaPedido;
    private StatusPedido statusPedido;

    public Pedido() {

    }

    public Pedido(Integer id, LocalDateTime horaPedido, StatusPedido statusPedido) {
        this.id = id;
        this.horaPedido = horaPedido;
        this.statusPedido = statusPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalDateTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", horaPedido=" + horaPedido +
                ", statusPedido=" + statusPedido +
                '}';
    }
}
