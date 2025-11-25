package interfaces.itf;

import java.math.BigDecimal;

public interface PagamentoOnlineService {

    BigDecimal taxaPagamento (BigDecimal valor);
    BigDecimal calculaJuros (BigDecimal valor, Integer meses);

}
