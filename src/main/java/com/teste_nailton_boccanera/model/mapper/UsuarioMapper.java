package com.teste_nailton_boccanera.model.mapper;

import com.teste_nailton_boccanera.model.entity.Usuario;
import com.teste_nailton_boccanera.model.request.UsuarioRequest;

public class UsuarioMapper {

    public static Usuario requestToEntity(UsuarioRequest usuario) {
        return Usuario.builder()
                .nome(usuario.nome())
                .senha(usuario.senha())
                .cargo(usuario.cargo())
                .ativo(usuario.ativo())
                .build();
    }
}
