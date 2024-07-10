package com.youx.teste_nailton_boccanera.service.interf;

import com.youx.teste_nailton_boccanera.model.request.UsuarioRequest;
import com.youx.teste_nailton_boccanera.model.response.UsuarioResponse;

public interface IUsuarioService {
    UsuarioResponse create(UsuarioRequest usuario);
}
