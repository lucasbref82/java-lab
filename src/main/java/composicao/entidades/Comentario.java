package composicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comentario {

    private String texto;

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
