package com.redetex.web.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SituacaoEnum {
    NOVO(1, "NOVO"),
    AGENDADO(2, "AGENDADO"),
    CONCLUIDO(3, "CONCLUIDO"),
    CANCELADO(4, "CANCELADO");

    private final Integer id;
    private final String situacao;
}
