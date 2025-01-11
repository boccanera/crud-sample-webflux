package com.teste_nailton_boccanera.controller;

import com.teste_nailton_boccanera.model.response.UfResponse;
import com.teste_nailton_boccanera.service.interf.IIBGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class IBGEController {

    private final IIBGEService ibgeService;

    @Autowired
    public IBGEController(IIBGEService ibgeService){
        this.ibgeService = ibgeService;
    }

    @GetMapping("/estados")
    public ResponseEntity<Flux<UfResponse>> listaEstados (){
        Flux<UfResponse> fluxUf = ibgeService.findAll();
        return ResponseEntity.ok().body(fluxUf);
    }

}
