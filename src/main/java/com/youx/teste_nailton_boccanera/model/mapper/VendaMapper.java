package com.youx.teste_nailton_boccanera.model.mapper;

import com.youx.teste_nailton_boccanera.model.entity.Cliente;
import com.youx.teste_nailton_boccanera.model.entity.Venda;
import com.youx.teste_nailton_boccanera.model.request.VendaRequest;

import java.time.LocalDate;

public class VendaMapper {

    public static Venda requestToEntity(VendaRequest venda, Cliente cliente) {
        return Venda.builder()
                .cliente(cliente)
                .data(LocalDate.now())
                .status(venda.status())
                .valor(venda.valor())
                .build();
    }

}
