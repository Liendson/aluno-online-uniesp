package com.redetex.web.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SituacaoClienteEnum {
    ATIVO(1, "ATIVO"),
    CANCELADO(2, "CANCELADO");

    private final Integer id;
    private final String situacao;
}
