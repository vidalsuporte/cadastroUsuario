package com.vidalsuporte.cadastroUsuario.service;


import com.vidalsuporte.cadastroUsuario.domain.usuario.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {


    private final Usuario usuario;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;




    public DetalhesUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario){
    var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario, passwordEncoder.encode(dadosCadastroUsuario.senha())));
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

        usuarioAtualizado.atualizarDados(dadosAtualizaUsuario, dadosAtualizaUsuario.senha() !=null ?  passwordEncoder.encode(dadosAtualizaUsuario.senha()): null);
        return new DetalhesUsuario(usuarioRepository.save(usuarioAtualizado));
   }


    public void detelar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
