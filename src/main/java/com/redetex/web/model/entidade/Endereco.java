package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_ENDERECOS")
@NoArgsConstructor
public class Endereco {

    @Column(name = "RUA")
    String nomeRua;

    @Column(name = "BAIRRO")
    String bairro;

    @Column(name = "NRCEP")
    String cepRua;

    @Column(name = "NOMEEDIFICIO")
    String nomeEdificio;

    @Column(name = "NRAPARTAMENTO")
    int apartamentoEdificio;

    @Column(name = "NREDIFICIO")
    int numeroEdificio;

}
