package com.redetex.web.model.entidade;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_MEDIDAS")
@NoArgsConstructor
public class Medida {

    @Id
    @Column(name = "IDMEDIDA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "LARGURA")
    Float largura;

    @Column(name = "ALTURA")
    Float altura;

    @Column(name = "MTQUADRADOS")
    Float metrosQuadrados;

    @Builder
    public Medida(
            Long id,
            Float largura,
            Float altura,
            Float metrosQuadrados
    ) {
        this.id = id;
        this.largura = largura;
        this.altura = altura;
        this.metrosQuadrados = metrosQuadrados;
    }

}
