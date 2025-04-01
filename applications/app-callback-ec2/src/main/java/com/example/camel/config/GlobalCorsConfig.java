package com.example.camel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Adicione todas as origens de desenvolvimento relevantes
        config.addAllowedOrigin("http://localhost:5500"); // VS Code Live Server padrão
        config.addAllowedOrigin("http://127.0.0.1:5501"); // Nova origem do seu frontend
        config.addAllowedOrigin("http://localhost:8080"); // Backend (se necessário)

        // Métodos permitidos
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS"); // Essencial para pré-flight requests

        // Headers permitidos
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Accept");

        config.setAllowCredentials(false); // Altere para true se usar autenticação
        config.setMaxAge(3600L); // Cache de configurações CORS por 1 hora

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplica a todas as rotas

        return new CorsFilter(source);
    }
}