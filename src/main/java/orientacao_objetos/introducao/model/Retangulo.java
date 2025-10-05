package orientacao_objetos.introducao.model;

public class Retangulo {

    private double largura;
    private double altura;

    public Retangulo() {

    }

    public Retangulo(double largura, double altura) throws Exception {
        if (largura < 0 || altura < 0) {
            throw new Exception("Altura e largura não podem ser menor que zero");
        }
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area() {
        return altura * largura;
    }

    public double perimetro() {
        return (altura + altura) + (largura + largura);
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(altura, 2) + Math.pow(largura, 2));
    }
}
