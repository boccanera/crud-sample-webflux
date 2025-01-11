package com.teste_nailton_boccanera.service.interf;

import com.teste_nailton_boccanera.model.request.ClienteRequest;
import com.teste_nailton_boccanera.model.response.ClienteResponse;

public interface IClienteService {
    ClienteResponse create(ClienteRequest usuario);
}
