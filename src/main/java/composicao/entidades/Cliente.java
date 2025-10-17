package composicao.entidades;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String email, LocalDate dataAniversario) {
        super(nome, dataAniversario);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
