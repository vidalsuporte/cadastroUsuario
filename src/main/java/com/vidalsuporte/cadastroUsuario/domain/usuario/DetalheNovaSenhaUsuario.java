package com.vidalsuporte.cadastroUsuario.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalheNovaSenhaUsuario(
        @NotNull
        Long id,
        @NotBlank
        String senhaAntiga,
        @NotBlank
        String senhaNova,
        @NotBlank
        String senhaConfirmacao) {
}
