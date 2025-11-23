package com.vidalsuporte.cadastroUsuario.controller.springDoc;

import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosAtualizaUsuario;
import com.vidalsuporte.cadastroUsuario.domain.usuario.DadosCadastroUsuario;
import com.vidalsuporte.cadastroUsuario.domain.usuario.DetalhesUsuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@SecurityRequirement(name = "bearer-key")
@Tag(name = "Usuário")
public interface IUsuarioController {

    @Operation(summary = "Cadastro dos Usuários.")
    @ApiResponse(responseCode = "204", description = "Entrada de dados para cadastro dos Usuários.")
    public ResponseEntity<DetalhesUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario, UriComponentsBuilder uriComponentsBuilder);

    @Operation(summary = "Lista todos os Usuários cadastrados .")
    @ApiResponse(responseCode = "200", description = "Retorna lista com todos os Usuários.")
    public ResponseEntity<Page<DetalhesUsuario>>listarTodos(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable);

    @Operation(summary = "Busca Usuário cadastrado por Id.")
    @ApiResponse(responseCode = "200", description = "Retorna Usuário cadastrado.")
    public ResponseEntity<DetalhesUsuario> buscaPorId(@PathVariable Long id);

    @Operation(summary = "Busca Usuário cadastrado por nome.")
    @ApiResponse(responseCode = "200", description = "Retorna Usuário cadastrado.")
    public ResponseEntity<DetalhesUsuario> buscaPorNome(@PathVariable String nome);

    @Operation(summary = "Atualiza dados dos Usuários.")
    @ApiResponse(responseCode = "200", description = "Entrada de dados para atualizar dos Usuários.")
    public ResponseEntity<DetalhesUsuario> atualizar(@RequestBody @Valid DadosAtualizaUsuario dadosAtualizaUsuario);

    @Operation(summary = "Exclui Usuário Cadastrado .")
    @ApiResponse(responseCode = "200", description = "Exclui Usuário cadastrado por Id.")
    public ResponseEntity deletar(@PathVariable Long id);




}
