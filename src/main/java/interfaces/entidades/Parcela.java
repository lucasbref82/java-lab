package interfaces.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Parcela {

    private LocalDate dataParcela;
    private BigDecimal valorParcela;

    public Parcela() {
    }

    public Parcela(LocalDate dataParcela, BigDecimal valorParcela) {
        this.dataParcela = dataParcela;
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataParcela() {
        return dataParcela;
    }

    public void setDataParcela(LocalDate dataParcela) {
        this.dataParcela = dataParcela;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }
}
