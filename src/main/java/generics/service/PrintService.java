package generics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PrintService<Tipo> {

    List<Tipo> list;

    public PrintService() {
        this.list = new ArrayList<>();
    }

    public void add(Tipo valor) {
        this.list.add(valor);
    }

    public Tipo primeiro() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("A lista está nula!");
        }
        return list.get(0);
    }

    public void imprime() {
        System.out.println(list);
    }

}
