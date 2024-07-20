package tech.desafio_backend_bossabox.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciamento de ferramentas")
                        .version("v1")
                        .description(" A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags."));

    }
}
