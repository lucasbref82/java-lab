package composicao.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoraContrato {
    private LocalDateTime data;
    private BigDecimal valorPorHora;
    private Integer horas;

    public HoraContrato() {
    }

    public HoraContrato(LocalDateTime data, BigDecimal valorPorHora, Integer horas) {
        this.data = data;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    private BigDecimal valorTotal() {
        return valorPorHora.multiply(BigDecimal.valueOf(horas));
    }
}
