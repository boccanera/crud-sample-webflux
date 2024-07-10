package com.youx.teste_nailton_boccanera.config.strategy;

public class PagamentoAprovado implements StatusVendaStrategy {

    @Override
    public String processar() {
        return "Email de pagamento efetuado com sucesso e atualização no banco de dados.";
    }

}
