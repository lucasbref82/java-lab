package orientacao_objetos.introducao.estaticos.utils;

public final class ConversorUtils {

    private ConversorUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Classe utilitária não pode ser instanciada.");
    }
    private static final int PORCENTAGEM_ACRESCIMO = 6;
    private static final int DIVIDENDO_PORCENTAGEM = 100;

    public static double conversorDolarEmReais(double valorDolar, double quantidadeDolar) {
        double valorTotal = valorDolar * quantidadeDolar;
        return calculaAcrecimoPorcentagem(valorTotal);
    }

    private static double calculaAcrecimoPorcentagem(double valorAcrescentado) {
        return (double) PORCENTAGEM_ACRESCIMO / DIVIDENDO_PORCENTAGEM * valorAcrescentado + valorAcrescentado;
    }
}
