package com.youx.teste_nailton_boccanera.service.interf;

import com.youx.teste_nailton_boccanera.model.request.VendaRequest;
import com.youx.teste_nailton_boccanera.model.response.VendaResponse;

import java.util.Optional;

public interface IVendaService {

    Optional<VendaResponse> create(VendaRequest usuario);
}
