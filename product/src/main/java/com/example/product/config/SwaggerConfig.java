package com.example.product.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "ProductMicroService",
                        email = ""

                ),
                description = "Open Api documentation for ProductMicroService",
                title = "OpenApi ProductMicroService",
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
