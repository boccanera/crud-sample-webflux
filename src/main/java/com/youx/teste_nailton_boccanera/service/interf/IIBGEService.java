package com.youx.teste_nailton_boccanera.service.interf;

import com.youx.teste_nailton_boccanera.model.response.UfResponse;
import reactor.core.publisher.Flux;

public interface IIBGEService {

    Flux<UfResponse> findAll();

}
