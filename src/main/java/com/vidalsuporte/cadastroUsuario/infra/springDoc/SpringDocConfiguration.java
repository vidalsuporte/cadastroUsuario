package com.vidalsuporte.cadastroUsuario.infra.springDoc;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI custonOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Cadastro de Usuários ")
                        .description("API Rest de cadastro de usuários com autenticação utilizando spring security e tokey JWT")
                        .contact(new Contact()
                                .name("André Gonçalves Vidal")
                                .email("vidalsuporte@gmail.com"))
                        .license(new License()
                                .name("Licença MIT")
                                .url("https://pt.wikipedia.org/wiki/Licen%C3%A7a_MIT"))
                ).tags(
                        Arrays.asList(
                                new Tag().name("Usuário").description("EndPoint para manipular dados do Usuário."),
                                new Tag().name("Login").description("EndPoint para gerenciar login.")
                                )
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")));




    }

}
