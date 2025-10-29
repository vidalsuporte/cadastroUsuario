package com.vidalsuporte.cadastroUsuario.domain.usuario;

import com.vidalsuporte.cadastroUsuario.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaUsuario(

   @NotNull
    Long id,


    String nome,


    String telefone,


    String senha,


    @Email
    String email,

   String perfil
) {
}
