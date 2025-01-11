package com.teste_nailton_boccanera.model.enums;

public enum StatusVenda {

    AGUARDANDO_PAGAMENTO("Aguardando pagamento"),
    PAGAMENTO_APROVADO("Pagamento aprovado"),
    AGUARDANDO_ENVIO("Aguardando envio"),
    A_CAMINHO("À caminho"),
    FINALIZADO("Finalizado");

    private final String descricao;

    StatusVenda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
