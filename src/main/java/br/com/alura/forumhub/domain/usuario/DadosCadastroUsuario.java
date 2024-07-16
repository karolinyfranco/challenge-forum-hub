package br.com.alura.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String senha) {
}
