package com.vidalsuporte.cadastroUsuario.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity(name="Usuario")
@Table(name="tb_usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;


    public void atualizarDados(@Valid DadosAtualizaUsuario dadosAtualizaUsuario) {
        if(dadosAtualizaUsuario.nome()!= null){
            this.nome = dadosAtualizaUsuario.nome();
        }
        if(dadosAtualizaUsuario.email()!= null){
            this.email = dadosAtualizaUsuario.email();
        }
        if(dadosAtualizaUsuario.senha()!= null){
            this.senha = dadosAtualizaUsuario.senha();
        }
        if(dadosAtualizaUsuario.telefone()!= null){
            this.telefone = dadosAtualizaUsuario.telefone();
        }



    }
}
