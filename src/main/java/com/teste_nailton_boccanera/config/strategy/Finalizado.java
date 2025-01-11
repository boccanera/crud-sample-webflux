package com.teste_nailton_boccanera.config.strategy;

public class Finalizado implements StatusVendaStrategy {
    @Override
    public String processar() {
        return "Email de pedido finalizado e atualização no banco de dados.";
    }
}
