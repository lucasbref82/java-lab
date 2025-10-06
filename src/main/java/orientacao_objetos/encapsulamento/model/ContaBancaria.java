package orientacao_objetos.encapsulamento.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private BigDecimal saldo;
    private static final BigDecimal VALOR_TAXA_SAQUE = BigDecimal.valueOf(5);

    public ContaBancaria(int numeroConta, String nomeTitular) {
        verificarSeNumeroContaMenorIgualZero(numeroConta);
        verificarSeNomeTitularVazioOuNulo(nomeTitular);
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public ContaBancaria(int numeroConta, String nomeTitular, BigDecimal saldo) {
        verificarSeNumeroContaMenorIgualZero(numeroConta);
        verificarSeNomeTitularVazioOuNulo(nomeTitular);
        validarSeValorNuloOuNegativo(saldo);
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        depositar(saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor) {
        validarSeValorNuloOuNegativo(valor);
        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        validarSeValorNuloOuNegativo(valor);
        this.saldo = this.saldo.subtract(valor).subtract(VALOR_TAXA_SAQUE);

    }

    public void validarSeValorNuloOuNegativo(BigDecimal valor) {
        Objects.requireNonNull(valor, "Valor informado não pode ser nulo.");
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor informado não pode ser menor que zero");
        }
    }

    public void verificarSeNomeTitularVazioOuNulo(String nomeTitular) {
        if (nomeTitular == null || nomeTitular.isBlank()) {
            throw new IllegalArgumentException("Nome do titular não pode ser vazio.")
        }
    }

    public void verificarSeNumeroContaMenorIgualZero(int numeroConta) {
        if (numeroConta <= 0) {
            throw new IllegalArgumentException("Número da conta não pode ser menor ou igual a zero");
        }
    }
}
