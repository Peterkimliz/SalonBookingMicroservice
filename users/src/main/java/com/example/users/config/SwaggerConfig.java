package com.example.users.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "UserMicroService",
                        email = ""

                ),
                description = "Open Api documentation for UserMicroService",
                title = "OpenApi UserMicroService",
                version = "1.0"
        )
        , servers = {
        @Server(
                description = "Production ENV",
                url = "${server.remoteLink}"
        ),
        @Server(
                description = "Local ENV",
                url = "${server.localLink}"
        )

}

)

public class SwaggerConfig {
}
