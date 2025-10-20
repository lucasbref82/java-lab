package abstracao.entidades;

public class PessoaJuridica extends Pessoa{
    private Integer numeroFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
}
