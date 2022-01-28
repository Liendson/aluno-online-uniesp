package com.redetex.web.model.entidade;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
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

    @Builder
    public Endereco(
            Long idEndereco,
            String nomeRua,
            String bairro,
            String cepRua,
            String nomeEdificio,
            int apartamentoEdificio,
            int numeroEdificio
    ) {
        this.idEndereco = idEndereco;
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.cepRua = cepRua;
        this.nomeEdificio = nomeEdificio;
        this.apartamentoEdificio = apartamentoEdificio;
        this.numeroEdificio = numeroEdificio;
    }

}
