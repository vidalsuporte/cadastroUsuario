package com.vidalsuporte.cadastroUsuario.controller;


import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosAutenticacao;
import com.vidalsuporte.cadastroUsuario.domain.usuario.Usuario;
import com.vidalsuporte.cadastroUsuario.infra.security.TokenJWT;
import com.vidalsuporte.cadastroUsuario.infra.security.TokenService;
import com.vidalsuporte.cadastroUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AutenticacaoController{

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao usuario){

            var token = new UsernamePasswordAuthenticationToken(usuario.email(),usuario.senha());
            var autentication = authenticationManager.authenticate(token);
            var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());

            return ResponseEntity.ok(new TokenJWT(tokenJWT));


    }



}
