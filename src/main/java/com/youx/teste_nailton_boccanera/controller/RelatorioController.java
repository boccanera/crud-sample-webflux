package com.youx.teste_nailton_boccanera.controller;

import com.youx.teste_nailton_boccanera.model.response.RelatorioResponse;
import com.youx.teste_nailton_boccanera.service.interf.IRelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final IRelatorioService relatorioService;

    @Autowired
    public RelatorioController(IRelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<RelatorioResponse>> gerarRelatorioTop10ValorTotal() {
        return ResponseEntity.ok().body(relatorioService.gerarRelatorioTop10Faturamento());
    }

}

