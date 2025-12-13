package com.vidalsuporte.cadastroUsuario.service;


import com.vidalsuporte.cadastroUsuario.domain.usuario.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {



    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;




    public DetalhesUsuario salvar(@Valid DadosCadastroUsuario dadosCadastroUsuario){
    var usuario = usuarioRepository.save(new Usuario(dadosCadastroUsuario, passwordEncoder.encode(dadosCadastroUsuario.senha())));
    return new DetalhesUsuario(usuario);
    }


   public DetalhesUsuario buscaPorId(Long id){

       Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(usuario.getId() != id && usuario.getPerfil().toString().equals("USUARIO")) {
           throw new RuntimeException("Acesso negado Somente Administrador pode Buscar dados de outro usuário!");
       }

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

       Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       if(usuario.getId() != usuarioAtualizado.getId() && usuario.getPerfil().toString().equals("USUARIO")) {
           throw new RuntimeException("Acesso negado Somente Administrador pode Alterar dados de outro usuário!");
       }

        usuarioAtualizado.atualizarDados(dadosAtualizaUsuario);
        return new DetalhesUsuario(usuarioRepository.save(usuarioAtualizado));
   }


    public void detelar(Long id) {
        usuarioRepository.deleteById(id);
    }


    public DetalhesUsuario atualizarSenha(DetalheNovaSenhaUsuario usuarioNovaSenha){
        var usuarioAtualizado = usuarioRepository.getReferenceById(usuarioNovaSenha.id());

        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(usuario.getId() != usuarioAtualizado.getId() && usuario.getPerfil().toString().equals("USUARIO")) {
            throw new RuntimeException("Acesso negado Somente Administrador pode Alterar dados de outro usuário!");
        }
        if(passwordEncoder.matches(usuarioNovaSenha.senhaAntiga(), usuario.getPassword())){
            if (usuarioNovaSenha.senhaNova().equals(usuarioNovaSenha.senhaConfirmacao())) {
           usuarioAtualizado.setSenha(passwordEncoder.encode(usuarioNovaSenha.senhaNova()));
            }else {
                throw new RuntimeException("Confirmação de senha inválida, senha de confirmação e senha nova devem ser iguais!");

            }
        }else{
            throw new RuntimeException("Senha Atual inválida!");
        }

        usuarioRepository.save(usuarioAtualizado);
      
        return new DetalhesUsuario(usuario);
    }



}
