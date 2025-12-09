package generics.service;

import java.util.ArrayList;
import java.util.List;

public class PrintServiceMotivadorReuso {
    List<Integer> list;

    public PrintServiceMotivadorReuso() {
        list = new ArrayList<>();
    }

    public void adicionaValor(Integer valor) {
        list.add(valor);
    }

    public Integer primeiro() throws IllegalAccessException {
        if (list.isEmpty()) {
            throw new IllegalAccessException("A lista está vazia.");
        }
        return list.get(0);
    }

    public void imprime() {
        System.out.println(list.toString());
    }

}
