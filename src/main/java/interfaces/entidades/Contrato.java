package interfaces.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Contrato {

    private Integer numero;
    private LocalDate data;
    private BigDecimal valorContrato;
    private List<Parcela> parcelas;

    public Contrato() {
    }

    public Contrato(Integer numero, LocalDate data, BigDecimal valorContrato) {
        this.numero = numero;
        this.data = data;
        this.valorContrato = valorContrato;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(BigDecimal valorContrato) {
        this.valorContrato = valorContrato;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public void addParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }
}
