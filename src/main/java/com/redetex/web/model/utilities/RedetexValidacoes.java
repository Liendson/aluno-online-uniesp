package com.redetex.web.model.utilities;

public enum RedetexValidacoes {

    // Mensagens de Erro
    ERRO_CLIENTE_NAO_EXISTE("Cliente não Existe!"),
    ERRO_ORCAMENTO_NAO_EXISTE("Orçamento não Existe!"),
    ERRO_SERVICO_NAO_EXISTE("Serviço não Existe!"),

    ERRO_SITUACAO_INVALIDA("Situação Inválida!"),

    // Mensagens de Alerta
    ALERTA_PREENCHA_UM_CAMPO("Preencha no mínimo um campo para consultar!");

    private String textoErro;

    RedetexValidacoes(String textoErro) {
        this.textoErro = textoErro;
    }

    public String getTexto() {
        return this.textoErro;
    }
}
