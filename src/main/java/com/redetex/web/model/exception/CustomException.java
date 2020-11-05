package com.redetex.web.model.exception;

import com.redetex.web.model.utilities.RedetexValidacoes;

public class CustomException extends Exception {

    public CustomException(RedetexValidacoes errorMessage, Throwable error) {
        super(errorMessage.getTexto(), error);
    }

    public CustomException(RedetexValidacoes errorMessage) {
        super(errorMessage.getTexto());
    }
}
