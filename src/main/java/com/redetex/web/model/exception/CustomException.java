package com.redetex.web.model.exception;

import com.redetex.web.model.utilities.RedetexValidacoes;

public class CustomException extends Exception {

    public CustomException(RedetexValidacoes errorMessage) {
        super(String.valueOf(errorMessage));
    }
}
