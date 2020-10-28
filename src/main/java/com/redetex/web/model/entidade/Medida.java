package com.redetex.web.model.entidade;

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
    int id;

    @Column(name = "LARGURA")
    Float largura;

    @Column(name = "ALTURA")
    Float altura;

    @Column(name = "MTQUADRADOS")
    Float metrosQuadrados;

}
