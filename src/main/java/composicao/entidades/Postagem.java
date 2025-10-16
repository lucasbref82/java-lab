package composicao.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Postagem {
    private LocalDateTime momento;
    private String titulo;
    private String conteudo;
    private Integer curtidas;
    private List<Comentario> comentarios = new ArrayList<>();

    public Postagem() {
    }

    public Postagem(LocalDateTime momento, String titulo, String conteudo, Integer curtidas) {
        this.momento = momento;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.curtidas = curtidas;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public void addAllComentarios(List<Comentario> comentarios) {
        this.comentarios.addAll(comentarios);
    }

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public void removeComentario(Comentario comentario) {
        comentarios.remove(comentario);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Postagem postagem = (Postagem) object;
        return Objects.equals(momento, postagem.momento) && Objects.equals(titulo, postagem.titulo) && Objects.equals(conteudo, postagem.conteudo) && Objects.equals(curtidas, postagem.curtidas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(momento, titulo, conteudo, curtidas);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(titulo).append("\n");
        stringBuilder.append(curtidas).append(" Curtidas").append(" - ").append(momento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        stringBuilder.append(conteudo).append("\n");
        stringBuilder.append("Comentários: \n");
        for(Comentario c :comentarios) {
            stringBuilder.append(c.getTexto()).append("\n");
        }
        return stringBuilder.toString();
    }
}
