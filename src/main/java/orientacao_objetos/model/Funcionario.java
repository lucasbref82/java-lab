package orientacao_objetos.model;

public class Funcionario {

    private String nome;
    private double salario;
    private double imposto;

    public Funcionario() {

    }

    public Funcionario(String nome, double salario, double imposto) {
        this.nome = nome;
        this.salario = salario;
        this.imposto = imposto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double salarioLiquido() throws Exception {
        if (imposto > salario) {
            throw new Exception("Imposto não pode ser menor que o salário.");
        }
        return salario - imposto;
    }

    public void aumentoSalario(double porcentagem) {
        double fatorAumento = 1 + (porcentagem / 100);
        salario = salario * fatorAumento;
    }
}
