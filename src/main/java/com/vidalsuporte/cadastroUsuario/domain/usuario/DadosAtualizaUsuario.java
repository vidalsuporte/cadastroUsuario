package com.vidalsuporte.cadastroUsuario.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaUsuario(

        @NotBlank
    Long id,


    String nome,


    String telefone,


    String senha,


    @Email
    String email
) {
}
