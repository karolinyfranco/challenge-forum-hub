package br.com.alura.forumhub.domain.usuario;

import br.com.alura.forumhub.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario cadastrar(DadosCadastroUsuario dados) {
        if (usuarioRepository.existsByEmail(dados.email())) {
            throw new ValidacaoException("Email já cadastrado no sistema.");
        }
        String senhaCodificada = passwordEncoder.encode(dados.senha());
        var usuario = new  Usuario(dados.email(), senhaCodificada);
        usuarioRepository.save(usuario);
        return usuario;
    }
}
