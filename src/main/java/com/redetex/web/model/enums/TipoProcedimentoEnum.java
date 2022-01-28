package com.redetex.web.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoProcedimentoEnum {

    ORCAMENTO(0, "ORCAMENTO"),
    SERVICO(1, "SERVICO");

    private final Integer id;
    private final String tipo;

    public static TipoProcedimentoEnum getValueOf(String id) {
        for (TipoProcedimentoEnum tp : TipoProcedimentoEnum.values()) {
            if (tp.getId().toString().equals(id)) {
                return tp;
            }
        }
        return null;
    }

}
