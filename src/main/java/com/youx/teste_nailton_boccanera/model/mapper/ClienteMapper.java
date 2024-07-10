package com.youx.teste_nailton_boccanera.model.mapper;

import com.youx.teste_nailton_boccanera.model.entity.Cliente;
import com.youx.teste_nailton_boccanera.model.request.ClienteRequest;

public class ClienteMapper {

    public static Cliente requestToEntity(ClienteRequest cliente) {
        return Cliente.builder()
                .nome(cliente.nome())
                .cnpj(cliente.cnpj())
                .email(cliente.email())
                .uf(cliente.uf())
                .telefone(cliente.telefone())
                .localizacao(cliente.localizacao())
                .build();
    }

}
