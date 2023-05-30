package com.alunoonline.api.model.utilities;

public enum AlunoOnlineValidacoes {

    // Mensagens de Erro
    ERRO_NAO_EXISTE("Entidade não Existe!"),

    ERRO_NAO_E_POSSIVEL_TRANCAR_MATRICULA("Não é possível trancar uma matrícula com status 'Matriculado'!"),
    ERRO_ALUNO_NAO_POSSUI_MATRICULAS("Esse aluno não possui nenhuma matrícula!");
    private final String textoErro;

    AlunoOnlineValidacoes(String textoErro) {
        this.textoErro = textoErro;
    }

    public String getTexto() {
        return this.textoErro;
    }
}
