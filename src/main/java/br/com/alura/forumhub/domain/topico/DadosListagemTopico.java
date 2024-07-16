package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  LocalDateTime data,
                                  String autor,
                                  Curso curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor(), topico.getCurso());
    }
}
