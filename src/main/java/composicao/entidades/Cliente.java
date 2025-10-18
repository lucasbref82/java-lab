package composicao.entidades;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Cliente extends Pessoa {

    private String email;

    public Cliente(String nome, String email, LocalDate dataAniversario) {
        super(nome, dataAniversario);
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Cliente cliente = (Cliente) object;
        return Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}
