package com.alunoonline.api.model.exception;

import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;

public class DefaultException extends RuntimeException {

    public static void ifTrueThrowException(boolean condition, AlunoOnlineValidacoes errorMessage) throws CustomException {
        if (condition) { throw new CustomException(errorMessage); }
    }

}
