package br.com.alura.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id,
                                       String email,
                                       String senha) {

    public DadosDetalhamentoUsuario(Usuario newUser) {
        this(newUser.getId(), newUser.getEmail(), newUser.getSenha());
    }
}
