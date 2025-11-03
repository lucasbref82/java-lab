package excessoes.modelo;

import excessoes.modelo.excessao.RegraNegocioException;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private final Integer numeroConta;
    private final String titular;
    private BigDecimal saldo;
    private final BigDecimal limiteSaque;

    public Conta(Integer numeroConta, String titular, BigDecimal saldo, BigDecimal limiteSaque) {
        Objects.requireNonNull(numeroConta, "Numero da conta não pode ser nulo.");
        Objects.requireNonNull(titular, "Titular da conta não pode ser nulo.");
        Objects.requireNonNull(saldo, "Saldo não pode ser nulo.");
        Objects.requireNonNull(limiteSaque, "Limite do saque não pode ser nulo.");
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }


    public Integer getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }


    public BigDecimal getLimiteSaque() {
        return limiteSaque;
    }



    public void depositar(BigDecimal valorDeposito) {
        Objects.requireNonNull(valorDeposito, "Valor do depósito não pode ser nulo.");
        saldo = saldo.add(valorDeposito);
    }

    public void sacar(BigDecimal valorSaque) throws RegraNegocioException {
        validaSaque(valorSaque);
        saldo = saldo.subtract(valorSaque);
    }

    private void validaSaque(BigDecimal valorSaque) throws RegraNegocioException {
        Objects.requireNonNull(valorSaque, "Valor do saque não pode ser nulo");
        if (valorSaque.compareTo(limiteSaque) > 0) {
            throw new RegraNegocioException("Valor do saque não pode ser maior que o limite de saque.");
        }
        if (valorSaque.compareTo(saldo) > 0) {
            throw new RegraNegocioException("Saldo insuficiente para o saque.");
        }
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Conta conta1 = (Conta) object;
        return Objects.equals(numeroConta, conta1.numeroConta);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroConta);
    }
}
