package interfaces;

import interfaces.entidades.Circulo;
import interfaces.entidades.FormaAbstrata;
import interfaces.entidades.Linha;
import interfaces.entidades.Retangulo;
import interfaces.enums.Cor;

public class ProgramaForma {
    public static void main(String[] args) {

        // Padrão utilizado Opcional Hieranchy Feature
        // A classe abstrata implementa a interface, quem extende a classe abstrata tem cor, mas podemos simplesmente criar uma classe sem cor e com área implementando a Interface.

        FormaAbstrata circulo = new Circulo(Cor.BRANCO, 3.0);
        FormaAbstrata retangulo = new Retangulo(Cor.PRETO, 4.0, 5.0);

        Linha linha = new Linha(7.4);

        circulo.area();
        retangulo.area();
        linha.area();
    }
}
