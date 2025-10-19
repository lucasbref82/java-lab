package abstracao.entidades;

import abstracao.enums.Cor;

import java.math.BigDecimal;

public abstract class Forma {

    private Cor cor;

    public Forma() {
    }

    public Forma(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public abstract BigDecimal area();

}
