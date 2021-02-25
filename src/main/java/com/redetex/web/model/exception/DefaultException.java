package com.redetex.web.model.exception;

import com.redetex.web.model.utilities.RedetexValidacoes;

public class DefaultException extends RuntimeException {

    public static void ifTrueThrowException(boolean condition, RedetexValidacoes errorMessage) throws CustomException {
        if (condition) { throw new CustomException(errorMessage); }
    }

}
