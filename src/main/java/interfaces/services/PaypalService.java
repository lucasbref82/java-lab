package interfaces.services;

import interfaces.itf.PagamentoOnlineService;

import java.math.BigDecimal;

public class PaypalService implements PagamentoOnlineService {

    private static final BigDecimal VALOR_TAXA_PAGAMENTO = BigDecimal.valueOf(0.02);

    @Override
    public BigDecimal taxaPagamento(BigDecimal valor) {
        return valor.multiply(VALOR_TAXA_PAGAMENTO);
    }

    @Override
    public BigDecimal calculaJuros(BigDecimal valor, Integer meses) {
        return valor.multiply(BigDecimal.valueOf(0.01)).multiply(BigDecimal.valueOf(meses));
    }
}
