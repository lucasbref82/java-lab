package interfaces.services;

import interfaces.entidades.Contrato;
import interfaces.entidades.Parcela;
import interfaces.itf.PagamentoOnlineService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ContratoService {

    private final PagamentoOnlineService pagamentoOnlineService;

    public ContratoService(PaypalService paypalService) {
        this.pagamentoOnlineService = paypalService;
    }

    public void processaContratos(Contrato contrato, int meses) {

        BigDecimal parcelaBasica = contrato.getValorContrato().divide(BigDecimal.valueOf(meses), RoundingMode.HALF_UP);
        for (int i = 1; i <= meses; i++) {

            LocalDate dataOriginal = contrato.getData().plusMonths(i);

            BigDecimal juros = pagamentoOnlineService.calculaJuros(parcelaBasica, i);
            BigDecimal taxa = pagamentoOnlineService.taxaPagamento(contrato.getValorContrato());

            BigDecimal parcelaFinal = parcelaBasica.add(juros).add(taxa);

            contrato.addParcela(new Parcela(dataOriginal, parcelaFinal));
        }
    }
}
