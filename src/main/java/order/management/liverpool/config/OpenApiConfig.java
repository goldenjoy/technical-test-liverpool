package order.management.liverpool.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Pedidos - Liverpool")
                        .description("CRUD de usuarios y pedidos con soporte para PostgreSQL y MongoDB")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Equipo Backend")
                                .email("backend@liverpool.com.mx")
                                .url("https://www.liverpool.com.mx"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación adicional")
                        .url("https://www.liverpool.com.mx/docs"));
    }
}
