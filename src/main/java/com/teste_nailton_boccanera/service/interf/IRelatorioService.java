package com.teste_nailton_boccanera.service.interf;

import com.teste_nailton_boccanera.model.response.RelatorioResponse;

import java.util.List;

public interface IRelatorioService {

    List<RelatorioResponse> gerarRelatorioTop10Faturamento();

}
