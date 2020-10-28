package com.redetex.web.model.entidade.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedidaDTO {

    Float largura;
    Float altura;
    Float metrosQuadrados;

    @Builder
    public MedidaDTO(
        Float largura,
        Float altura,
        Float metrosQuadrados
    ) {
        this.largura = largura;
        this.altura = altura;
        this.metrosQuadrados = metrosQuadrados;
    }

}
