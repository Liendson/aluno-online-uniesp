package com.alunoonline.api.model.exception;

import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;

public class CustomException extends Exception {

    public CustomException(AlunoOnlineValidacoes errorMessage, Throwable error) {
        super(errorMessage.getTexto(), error);
    }

    public CustomException(AlunoOnlineValidacoes errorMessage) {
        super(errorMessage.getTexto());
    }
}
