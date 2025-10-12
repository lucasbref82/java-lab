package estrutura_dados.lista;

import java.util.ArrayList;
import java.util.List;

public class OperacoesLista {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Lucas");
        list.add("Larissa");
        list.add("Olívia");
        list.add(1, "Emerson");
        list.add("Oseas");
        System.out.println(list.size());

        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------------");

        list.remove(1);
        list.removeIf(s -> s.charAt(0) == 'E');

        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------------");

        System.out.println("Index of Lucas: " + list.indexOf("Lucas"));
        System.out.println("Index of Lucas: " + list.indexOf("José"));

        System.out.println("-----------------------------");

        List<String> listNomes = list.stream().filter(s -> s.charAt(0) == 'O').toList();

        for (String s : listNomes) {
            System.out.println(s);
        }

        System.out.println("-----------------------------");

        String primeiroElemento = list.stream().filter(s -> s.charAt(0) == 'O').findFirst().orElse(null);
        System.out.println(primeiroElemento);

        System.out.println("-----------------------------");

        String segundoELemento = list.stream().filter(s -> s.charAt(0) == 'Z').findFirst().orElse(null);
        System.out.println(segundoELemento);






    }
}
