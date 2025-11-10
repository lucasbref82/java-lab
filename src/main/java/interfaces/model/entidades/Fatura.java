package interfaces.model.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class Fatura {
    private BigDecimal pagamentoBasico;
    private BigDecimal taxa;

    public Fatura() {
    }

    public Fatura(BigDecimal pagamentoBasico, BigDecimal taxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxa = taxa;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        public BigDecimal pagamentoBasico;
        public BigDecimal taxa;

        public Builder pagamentoBasico(BigDecimal pagamentoBasico) {
            this.pagamentoBasico = pagamentoBasico;
            return this;
        }

        public Builder taxa(BigDecimal taxa) {
            this.taxa = taxa;
            return this;
        }

        public Fatura build() {
            return new Fatura(pagamentoBasico, taxa);
        }
    }

    public BigDecimal getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(BigDecimal pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal pagamentoTotal() {
        return getPagamentoBasico().add(getTaxa());
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fatura fatura = (Fatura) o;
        return Objects.equals(pagamentoBasico, fatura.pagamentoBasico) && Objects.equals(taxa, fatura.taxa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagamentoBasico, taxa);
    }
}
