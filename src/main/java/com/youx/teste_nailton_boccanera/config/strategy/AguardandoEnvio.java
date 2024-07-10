package com.youx.teste_nailton_boccanera.config.strategy;

public class AguardandoEnvio implements StatusVendaStrategy {
    @Override
    public String processar() {
        return "Email de aguardando envio e atualização no banco de dados.";
    }
}
