package com.vidalsuporte.cadastroUsuario.controller.springDoc;


import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosAutenticacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Login")
public interface IAutenticacaoController {

    @Operation(summary = "Login.")
    @ApiResponse(responseCode = "200", description = "Login realizado e retornado um token JWT.")
    @ApiResponse(responseCode = "403", description = "Acesso não autorizado.")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao usuario);

}
