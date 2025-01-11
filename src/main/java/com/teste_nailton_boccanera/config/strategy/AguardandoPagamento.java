package com.teste_nailton_boccanera.config.strategy;

public class AguardandoPagamento implements StatusVendaStrategy {
    @Override
    public String processar() {
        return "Email de aguardando pagamento enviado com sucesso.";
    }
}
