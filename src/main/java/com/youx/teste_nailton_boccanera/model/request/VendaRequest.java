package com.youx.teste_nailton_boccanera.model.request;

import com.youx.teste_nailton_boccanera.model.entity.Cliente;
import com.youx.teste_nailton_boccanera.model.enums.StatusVenda;

import java.math.BigDecimal;

public record VendaRequest(Cliente cliente, StatusVenda status, BigDecimal valor) {}
