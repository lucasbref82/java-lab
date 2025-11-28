package interfaces.entidades;

import interfaces.enums.Cor;

public abstract class FormaAbstrata {

    private Cor cor;

    public FormaAbstrata() {
    }

    public FormaAbstrata(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }


}
