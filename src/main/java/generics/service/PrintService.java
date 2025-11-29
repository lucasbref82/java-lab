package generics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PrintService {

    List<Integer> list;

    public PrintService() {
        this.list = new ArrayList<>();
    }

    public void add(Integer integer) {
        this.list.add(integer);
    }

    public Integer primeiro() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("A lista está nula!");
        }
        return list.get(0);
    }

    public void imprime() {
        System.out.println(list);
    }

}
