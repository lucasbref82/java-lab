package interfaces.itf;

import java.math.BigDecimal;

public interface PagamentoOnlineService {

    BigDecimal taxaPagamento (BigDecimal taxa);
    BigDecimal calculaJuros (BigDecimal quantidade, Integer meses);

}
