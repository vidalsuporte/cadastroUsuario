package com.vidalsuporte.cadastroUsuario.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
        @NotNull
        String email,
        @NotNull
        String senha) {
}
