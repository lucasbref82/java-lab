package generics.service;

import java.util.ArrayList;
import java.util.List;

public class PrintServiceGenerico<Tipo> {
    private final List<Tipo> list;

    public PrintServiceGenerico() {
        list = new ArrayList<>();
    }

    public void add(Tipo tipo) {
        list.add(tipo);
    }

    public Tipo primeiro() {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia.");
        }
        return list.get(0);
    }

    public void imprime() {
        System.out.println(list);
    }
}
