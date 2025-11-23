package interfaces.services;

import interfaces.itf.TaxaService;

public class TaxaBrasilService implements TaxaService {

    @Override
    public double taxa(double quantidade) {
        if (quantidade <= 100) {
            return quantidade * 0.2;
        } else {
            return quantidade * 0.15;
        }
    }

}
