package com.vidalsuporte.cadastroUsuario.infra.configuracao;

import com.vidalsuporte.cadastroUsuario.domain.usuario.Usuario;
import com.vidalsuporte.cadastroUsuario.domain.usuario.UsuarioRepository;
import com.vidalsuporte.cadastroUsuario.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configBean {

    @Bean
    public Usuario usuario(){
        return new Usuario();
    }




}
