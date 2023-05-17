package com.alunoonline.api.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoEnum {

    REDE(0, "REDE"),
    PERSIANA(1, "PERSIANA"),
    CORTINA(2, "CORTINA"),
    TELA(3, "TELA"),
    BOX(4, "BOX");

    private final Integer id;
    private final String tipo;

    public static TipoEnum getValueOf(String id) {
        for (TipoEnum tp : TipoEnum.values()) {
            if (tp.getId().toString().equals(id)) {
                return tp;
            }
        }
        return null;
    }

}
