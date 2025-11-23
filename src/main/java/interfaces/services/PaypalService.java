package interfaces.services;

import interfaces.itf.PagamentoOnlineService;

import java.math.BigDecimal;

public class PaypalService implements PagamentoOnlineService {

    @Override
    public BigDecimal taxaPagamento(BigDecimal taxa) {
        return null;
    }

    @Override
    public BigDecimal calculaJuros(BigDecimal quantidade, Integer meses) {
        return null;
    }
}
