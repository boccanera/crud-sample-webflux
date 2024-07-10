package com.youx.teste_nailton_boccanera.service;

import com.youx.teste_nailton_boccanera.model.response.UfResponse;
import com.youx.teste_nailton_boccanera.service.interf.IIBGEService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@Service
public class IBGEService implements IIBGEService {

    private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1";
    private final WebClient webClient;

    @Autowired
    private IBGEService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<UfResponse> findAll() {
        log.info("Iniciando request /localidade/estados.");
        return webClient.get()
                .uri(BASE_URL + "/localidades/estados")
                .retrieve()
                .bodyToFlux(UfResponse.class)
                .timeout(Duration.ofMillis(10000));
    }
}

