package interfaces.services;

import interfaces.itf.PagamentoOnlineService;

public class ContratoService {

    private final PagamentoOnlineService pagamentoOnlineService;

    public ContratoService(PaypalService paypalService) {
        this.pagamentoOnlineService = paypalService;
    }
}
