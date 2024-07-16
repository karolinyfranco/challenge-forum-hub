package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.topico.*;
import br.com.alura.forumhub.domain.usuario.Usuario;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import br.com.alura.forumhub.infra.security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemTopico> cadastrarTopico(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosCriarTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(null, dados.titulo(), dados.mensagem(), LocalDateTime.now(), dados.autor(), dados.curso(), true);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemTopico> atualizarTopico(@RequestHeader("Authorization") String token, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopico> listarUmTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();
    }
}