package estrutura_dados.entidades;

import utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    private Integer id;
    private String nome;
    private BigDecimal salario;


    public Funcionario(BigDecimal salario, String nome, Integer id) {
        this.salario = salario;
        this.nome = nome;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public BigDecimal getSalario() {
        return salario;
    }


    public void acrescentarPorcentagem(BigDecimal porcentagem) {
        salario = salario.add(
                salario.multiply(porcentagem)
                        .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP)
        );
    }

    @Override
    public String toString() {
        return Utils.format("{}, {}, {}", id, nome, salario);
    }
}
