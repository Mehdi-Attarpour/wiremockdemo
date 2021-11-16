package io.ario.wiremockdemo.config;

import io.ario.wiremockdemo.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {

    @Bean
    public InfoRepository infoRepository(@Value("${info.baseUrl}") final String baseUrl){

        final WebClient webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();

        return new InfoRepository(webClient);
    }
}
