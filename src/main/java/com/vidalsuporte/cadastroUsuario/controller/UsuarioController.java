package com.vidalsuporte.cadastroUsuario.controller;


import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.cadastroUsuario.domain.usuario.DetalhesUsuario;
import com.vidalsuporte.cadastroUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<DetalhesUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder){


        var detalhesUsuario = usuarioService.salvar(dadosCadastroUsuario);
        System.out.println(detalhesUsuario);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(detalhesUsuario.id()).toUri();

        return ResponseEntity.created(uri).body(detalhesUsuario);

    }


    @GetMapping()
    @RequestMapping("/todos")
    public ResponseEntity<Page<DetalhesUsuario>>listarTodos(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable){
    var page = usuarioService.listarTodos(pageable);
    return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")

    public ResponseEntity<DetalhesUsuario> buscaPorId(@PathVariable Long id){
    return ResponseEntity.ok(usuarioService.buscaPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<DetalhesUsuario> buscaPorNome(@PathVariable String nome){
        return ResponseEntity.ok(usuarioService.buscaPorNome(nome));
    }

}
