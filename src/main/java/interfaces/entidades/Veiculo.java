package interfaces.entidades;

import java.util.Objects;

public class Veiculo {

    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(modelo, veiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(modelo);
    }
}
