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
    }
}
