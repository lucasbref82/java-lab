package interfaces.entidades;

import interfaces.enums.Cor;
import interfaces.itf.FormaItf;

public class Circulo extends FormaAbstrata{

    private Double raio;

    public Circulo() {

    }

    public Circulo(Cor cor, Double raio) {
        super(cor);
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public Double area() {
        return 0.0;
    }
}
