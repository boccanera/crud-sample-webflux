package com.teste_nailton_boccanera.config.strategy;

public class ACaminho implements StatusVendaStrategy {
    @Override
    public String processar() {
        return "Email de pedido a caminho e atualização no banco de dados.";
    }
}
