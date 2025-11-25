package interfaces.services;

import interfaces.entidades.Parcela;
import utils.TimeUtils;
import utils.Utils;

import java.math.RoundingMode;
import java.util.List;

public class ParcelaService {

    public void imprimeParcelas(List<Parcela> parcelas) {
        System.out.println("Parcelas: ");
        parcelas.forEach(parcela -> {
            String dataFormatada = parcela.getDataParcela().format(TimeUtils.LOCAL_DATE_PT_BR);
            System.out.println(
                    Utils.format("{} - {}",
                            dataFormatada,
                            parcela.getValorParcela().setScale(2, RoundingMode.HALF_UP)
                    )
            );
        });
    }
}
