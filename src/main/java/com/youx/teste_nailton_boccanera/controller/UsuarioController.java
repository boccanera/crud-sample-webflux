package com.youx.teste_nailton_boccanera.controller;

import com.youx.teste_nailton_boccanera.model.request.UsuarioRequest;
import com.youx.teste_nailton_boccanera.model.response.UsuarioResponse;
import com.youx.teste_nailton_boccanera.service.interf.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastroUsuario(@RequestBody UsuarioRequest usuario) {
        return ResponseEntity.ok().body(usuarioService.create(usuario));
    }

}

