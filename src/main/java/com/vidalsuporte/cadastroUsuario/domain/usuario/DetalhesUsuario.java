package com.vidalsuporte.cadastroUsuario.domain.usuario;

import com.vidalsuporte.cadastroUsuario.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record DetalhesUsuario(
        Long id,

        String nome,

        String senha,

        String telefone,

        String email,

        String perfil


)


{
    public DetalhesUsuario(Usuario usuario) {

        this(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmail(), String.valueOf(usuario.getPerfil())
        );


    }
}
