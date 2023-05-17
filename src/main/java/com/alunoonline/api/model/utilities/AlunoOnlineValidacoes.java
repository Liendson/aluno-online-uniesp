package com.alunoonline.api.model.utilities;

public enum AlunoOnlineValidacoes {

    // Mensagens de Erro
    ERRO_NAO_EXISTE("Entidade não Existe!");
    private String textoErro;

    AlunoOnlineValidacoes(String textoErro) {
        this.textoErro = textoErro;
    }

    public String getTexto() {
        return this.textoErro;
    }
}
