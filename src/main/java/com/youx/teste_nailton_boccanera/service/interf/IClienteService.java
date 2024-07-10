package com.youx.teste_nailton_boccanera.service.interf;

import com.youx.teste_nailton_boccanera.model.request.ClienteRequest;
import com.youx.teste_nailton_boccanera.model.response.ClienteResponse;

public interface IClienteService {
    ClienteResponse create(ClienteRequest usuario);
}
