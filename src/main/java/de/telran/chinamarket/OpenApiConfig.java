package de.telran.chinamarket;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

/**
 * Configuration class for OpenAPI documentation.
 * This class configures the OpenAPI documentation for the china-market API.
 * It defines security schemes and basic API information such as title and version.
 * This configuration class creates a custom OpenAPI bean with the specified security scheme and API information.
 * Класс конфигурации для документации OpenAPI.
 * Этот класс настраивает документацию OpenAPI для API china-market.
 * Он определяет схемы безопасности и основную информацию об API, такую как название и версия.
 * Этот класс конфигурации создает пользовательский бин OpenAPI с указанной схемой безопасности и информацией об API.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-02-22
 */
@Configuration
public class OpenApiConfig {
    /**
     * Creates a custom OpenAPI bean with security scheme and API information
     * Создает пользовательский бин OpenAPI со схемой безопасности и информацией об API.
     * @return OpenAPI object representing the API documentation / Возвращает объект OpenAPI, представляющий документацию API
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicAuth",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")
                ))
                .info(new Info().title("china-market API").version("v1"))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }
}
