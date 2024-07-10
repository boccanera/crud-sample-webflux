package com.youx.teste_nailton_boccanera.service;

import com.youx.teste_nailton_boccanera.model.response.RelatorioResponse;
import com.youx.teste_nailton_boccanera.repository.VendaRepository;
import com.youx.teste_nailton_boccanera.service.interf.IRelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService implements IRelatorioService {

    private final VendaRepository vendaRepository;

    @Autowired
    public RelatorioService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    @Cacheable("findTop10ClientesComMaiorFaturamento")
    public List<RelatorioResponse> gerarRelatorioTop10Faturamento() {
        return vendaRepository.findTop10ClientesComMaiorFaturamento();
    }

}
