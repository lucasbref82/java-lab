package interfaces.entidades;

import interfaces.itf.FormaItf;

public class Linha implements FormaItf {

    private Double comprimento;

    public Linha() {
    }

    public Linha(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public Double area() {
        return 0.0;
    }

}
