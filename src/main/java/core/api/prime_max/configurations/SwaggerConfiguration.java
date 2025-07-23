package core.api.prime_max.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server1 = new Server();
        server1.setUrl("https://url-futura-homologada.com");
        server1.setDescription("Server de homologação");

        Server server2 = new Server();
        server2.setUrl("https://url-futura-production.com");
        server2.setDescription("Servidor de produção");

        Server server3 = new Server();
        server3.setUrl("http://localhost:8080");
        server3.setDescription("Local");

        return new OpenAPI()
                .servers(Arrays.asList(server1, server2, server3))
                .info(new Info()
                        .title("prime-max")
                        .description("API Rest - Backend Application prime-max streaming")
                        .contact(new Contact()
                                .name("Prime Max Streaming")
                                .email("aplicativo@prime-max.com")));
    }
}
