package excessoes.modelo;

import excessoes.modelo.excessao.RegraNegocioException;
import utils.Utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ReservaHotel {
    
    private final Integer numeroQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public ReservaHotel(Integer numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) throws RegraNegocioException {
        validarDatas(dataEntrada, dataSaida);
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    
    public void atualizarDatas(LocalDate dataEntrada, LocalDate dataSaida) throws RegraNegocioException {
        validarDatas(dataEntrada, dataSaida);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public void validarDatas(LocalDate dataEntrada, LocalDate dataSaida) throws RegraNegocioException {
        if (dataEntrada.isAfter(dataSaida)) {
            throw new RegraNegocioException("Data de entrada não pode ser maior que a data de saída.");
        }
        if (dataEntrada.isBefore(LocalDate.now()) || dataSaida.isBefore(LocalDate.now())) {
            throw new RegraNegocioException("Reserva só pode ser feita para datas futuras.");
        }
    }

    public Long calculaTotalNoites() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ReservaHotel that = (ReservaHotel) object;
        return Objects.equals(numeroQuarto, that.numeroQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroQuarto);
    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + numeroQuarto + " Entrada: " + dataEntrada.format(Utils.LOCAL_DATE_PT_BR) + " Data saída: " + dataSaida.format(Utils.LOCAL_DATE_PT_BR) + ", " + calculaTotalNoites() + " noites";
    }
}
