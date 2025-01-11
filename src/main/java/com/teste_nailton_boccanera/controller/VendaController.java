package com.teste_nailton_boccanera.controller;

import com.teste_nailton_boccanera.model.request.VendaRequest;
import com.teste_nailton_boccanera.model.response.VendaResponse;
import com.teste_nailton_boccanera.service.interf.IVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final IVendaService vendaService;

    @Autowired
    public VendaController(IVendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaResponse> cadastroUsuario(@RequestBody VendaRequest vendaRequest) {
        return vendaService.create(vendaRequest)
                .map(response -> status(CREATED).body(response))
                .orElseGet(() -> status(INTERNAL_SERVER_ERROR).build());
    }

}
