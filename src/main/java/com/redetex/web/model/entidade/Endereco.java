package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_ENDERECOS")
@NoArgsConstructor
public class Endereco {

    @Id
    @Column(name = "IDENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEndereco;

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
