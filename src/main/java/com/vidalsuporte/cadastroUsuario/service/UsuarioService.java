package com.vidalsuporte.cadastroUsuario.service;


import com.vidalsuporte.cadastroUsuario.domain.usuario.*;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {


    private final Usuario usuario;
    private final UsuarioRepository usuarioRepository;




    public DetalhesUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario){
    var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario));
    return new DetalhesUsuario(usuario);
    }


   public DetalhesUsuario buscaPorId(Long id){
        return new DetalhesUsuario(usuarioRepository.findById(id).get());
   }

   public DetalhesUsuario buscaPorNome(String nome){

        return new DetalhesUsuario(usuarioRepository.findByNome(nome).get());

   }

   public Page<DetalhesUsuario> listarTodos(Pageable pageable){

        return usuarioRepository.findAll(pageable).map(DetalhesUsuario::new);

   }

   public DetalhesUsuario atualizar(@Valid DadosAtualizaUsuario dadosAtualizaUsuario){
        var usuarioAtualizado = usuarioRepository.getReferenceById(dadosAtualizaUsuario.id());
        usuarioAtualizado.atualizarDados(dadosAtualizaUsuario);
        return new DetalhesUsuario(usuarioRepository.save(usuarioAtualizado));
   }







}
