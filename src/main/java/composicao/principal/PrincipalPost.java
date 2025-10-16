package composicao.principal;

import composicao.entidades.Comentario;
import composicao.entidades.Postagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrincipalPost {
    public static void main(String[] args) {
        Postagem postagem = new Postagem();
        postagem.setMomento(LocalDateTime.parse("14/10/2025 11:35:44", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        postagem.setTitulo("Viajando para nova Zelândia");
        postagem.setConteudo("Estou indo visitar esse lindo páis!");
        postagem.setCurtidas(12);

        Comentario c1 = new Comentario("Tenha uma boa viagem");
        Comentario c2 = new Comentario("Uau isso é sensacional");

        postagem.addAllComentarios(List.of(c1, c2));

        System.out.println(postagem);

        postagem = new Postagem();
        postagem.setMomento(LocalDateTime.parse("15/10/2025 11:11:15", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        postagem.setTitulo("Boa noite pessoal.");
        postagem.setConteudo("Vejo vocês amanhã.");
        postagem.setCurtidas(5);

        c1 = new Comentario("Boa noite.");
        c2 = new Comentario("Ótima noite para você.");

        postagem.addAllComentarios(List.of(c1, c2));

        System.out.println(postagem);

    }
}
