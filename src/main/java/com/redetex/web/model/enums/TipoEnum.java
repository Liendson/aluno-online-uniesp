package com.redetex.web.model.enums;

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

}
