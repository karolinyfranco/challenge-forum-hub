package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCriarTopico(
        @NotBlank(message = "Título é obrigatório")
        String titulo,
        @NotBlank(message = "A mensagem do tópico não pode estar vazia")
        String mensagem,
        LocalDateTime data,
        @NotBlank(message = "Autor é obrigatório")
        String autor,
        @NotNull(message = "Curso é obrigatório")
        Curso curso) {
}
