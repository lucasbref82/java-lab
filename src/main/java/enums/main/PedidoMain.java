package enums.main;

import enums.StatusPedido;
import enums.entidades.Pedido;

import java.time.LocalDateTime;

public class PedidoMain {
    public static void main(String[] args) {

        Pedido pedido = new Pedido(1080, LocalDateTime.now(), StatusPedido.PENDENTE);
        System.out.println(pedido);
        StatusPedido sp = StatusPedido.ENVIADO;
        StatusPedido sp1 = StatusPedido.valueOf("ENVIADO");

        System.out.println(sp);
        System.out.println(sp1);
    }
}
