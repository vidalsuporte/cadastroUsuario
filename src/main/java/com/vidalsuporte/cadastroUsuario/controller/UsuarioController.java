package com.vidalsuporte.cadastroUsuario.controller;


import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.cadastroUsuario.domain.usuario.DetalhesUsuario;
import com.vidalsuporte.cadastroUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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





}
