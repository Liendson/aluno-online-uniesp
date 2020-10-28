package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
//@Table(name = "TB_MEDIDAS")
@NoArgsConstructor
public class Medida {

//    @Column(name = "LARGURA")
    Float largura;

//    @Column(name = "ALTURA")
    Float altura;

//    @Column(name = "MTQUADRADOS")
    Float metrosQuadrados;

}
