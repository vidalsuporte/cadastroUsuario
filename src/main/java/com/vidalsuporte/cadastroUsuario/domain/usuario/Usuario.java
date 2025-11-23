package com.vidalsuporte.cadastroUsuario.domain.usuario;


import com.vidalsuporte.cadastroUsuario.domain.perfil.Perfil;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Entity(name="Usuario")
@Table(name="tb_usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;


    public Usuario(@Valid DadosCadastroUsuario dadosCadastroUsuario) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = dadosCadastroUsuario.senha();
        this.telefone = dadosCadastroUsuario.telefone();
        this.perfil = Perfil.valueOf(dadosCadastroUsuario.perfil());
    }

    public Usuario(@Valid DadosCadastroUsuario dadosCadastroUsuario, String encode) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.senha = encode;
        this.telefone = dadosCadastroUsuario.telefone();
        this.perfil = Perfil.valueOf(dadosCadastroUsuario.perfil());
    }

    public void atualizarDados(@Valid DadosAtualizaUsuario dadosAtualizaUsuario, String senha) {
        if(dadosAtualizaUsuario.nome()!= null){
            this.nome = dadosAtualizaUsuario.nome();
        }
        if(dadosAtualizaUsuario.email()!= null){
            this.email = dadosAtualizaUsuario.email();
        }
        if(senha!= null){
            this.senha = senha;
        }
        if(dadosAtualizaUsuario.telefone()!= null){
            this.telefone = dadosAtualizaUsuario.telefone();
        }
        if(dadosAtualizaUsuario.perfil() != null){
            this.perfil = Perfil.valueOf(dadosAtualizaUsuario.perfil());
        }



    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var perfil = new SimpleGrantedAuthority("ROLE_" + this.perfil);


        return Collections.singleton(perfil);
    }


    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}