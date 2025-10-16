package composicao.entidades;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, LocalDate dataAniversario, String email) {
        super(nome, dataAniversario);
        this.email = email;
    }
}
