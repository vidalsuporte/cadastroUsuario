package com.vidalsuporte.cadastroUsuario.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DetalhesUsuario(
        Long id,

        String nome,

        String senha,

        String telefone,

        String email


) {
    public DetalhesUsuario(Usuario usuario) {

        this(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmail());


    }
}
