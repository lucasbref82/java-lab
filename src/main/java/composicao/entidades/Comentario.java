package composicao.entidades;

import java.util.Objects;

public class Comentario {
    private String texto;

    public Comentario() {
    }

    public Comentario(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Comentario that = (Comentario) object;
        return Objects.equals(texto, that.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(texto);
    }
}
