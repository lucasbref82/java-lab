package interfaces.entidades;

import interfaces.enums.Cor;

public class Retangulo extends FormaAbstrata{

    private Double largura;
    private Double altura;

    public Retangulo(Double largura, Double altura, Cor cor) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

}
