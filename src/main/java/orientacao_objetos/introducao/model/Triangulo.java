package orientacao_objetos.introducao.model;

public class Triangulo {
    public double a, b, c;

    public double CalculaArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
