package composicao.entidades;

import composicao.enums.Senioridade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trabalhador {
    private String nome;
    private Senioridade senioridade;
    private BigDecimal salarioBase;
    private List<HoraContrato> horaContratos = new ArrayList<>();
    private Departamento departamento;

    public Trabalhador() {
    }

    public Trabalhador(String nome, Senioridade senioridade, BigDecimal salarioBase, List<HoraContrato> horaContratos, Departamento departamento) {
        this.nome = nome;
        this.senioridade = senioridade;
        this.salarioBase = salarioBase;
        this.horaContratos.addAll(horaContratos);
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Senioridade getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(Senioridade senioridade) {
        this.senioridade = senioridade;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void adicionaContrato(HoraContrato horaContrato) {
        horaContratos.add(horaContrato);
    }

    public void removeContrato(HoraContrato horaContrato) {
        horaContratos.remove(horaContrato);
    }

    public BigDecimal renda(Integer ano, Integer mes){
        return BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Trabalhador that = (Trabalhador) object;
        return Objects.equals(nome, that.nome) && Objects.equals(senioridade, that.senioridade) && Objects.equals(salarioBase, that.salarioBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, senioridade, salarioBase);
    }
}
