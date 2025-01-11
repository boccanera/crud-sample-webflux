package com.teste_nailton_boccanera.model.response;

import com.teste_nailton_boccanera.model.enums.StatusVenda;

import java.math.BigDecimal;

public record VendaResponse(String cliente, StatusVenda status, BigDecimal valor) {
}
