package com.youx.teste_nailton_boccanera.controller;


import com.youx.teste_nailton_boccanera.model.request.ClienteRequest;
import com.youx.teste_nailton_boccanera.model.response.ClienteResponse;
import com.youx.teste_nailton_boccanera.service.interf.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


        private final IClienteService clienteService;

        @Autowired
        public ClienteController(IClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @PostMapping
        public ResponseEntity<ClienteResponse> cadastroUsuario(@RequestBody ClienteRequest clienteRequest) {
            return ResponseEntity.ok(clienteService.create(clienteRequest));
        }

}
