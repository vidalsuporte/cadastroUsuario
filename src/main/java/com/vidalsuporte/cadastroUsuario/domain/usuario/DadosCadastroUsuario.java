package com.vidalsuporte.cadastroUsuario.domain.usuario;


import com.vidalsuporte.cadastroUsuario.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(

@NotBlank
String nome,

@NotBlank
String senha,


String telefone,

@NotBlank
@Email
String email,

@NotBlank
String perfil


) {
}
