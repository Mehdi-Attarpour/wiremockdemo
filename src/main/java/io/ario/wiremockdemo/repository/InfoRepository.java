package io.ario.wiremockdemo.repository;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class InfoRepository {

    private final WebClient webClient;

    public InfoRepository(final WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Boolean> isInfoTrue() {
        return webClient
                .get()
                .uri("/info")
                .header("Country", "Sweden")
                .exchangeToMono(this::transformResponse);
    }

    private Mono<Boolean> transformResponse(final ClientResponse response) {
        if(response.statusCode().is2xxSuccessful()){
          return Mono.just(true);
        }
        return Mono.error(new RuntimeException("Something bad happened!!!"));
    }
}
