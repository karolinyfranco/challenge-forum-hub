package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.ValidacaoException;
import br.com.alura.forumhub.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        try {
            Usuario newUser = usuarioService.cadastrar(dados);
            return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoUsuario(newUser));
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
