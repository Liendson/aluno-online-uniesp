package com.redetex.web.model.entidade;

import com.redetex.web.model.enums.SituacaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TB_SERVICOS")
@NoArgsConstructor
public class Servico {

    @Id
    @Column(name = "IDSERVICO")
    int idServico;

    @Column(name = "SITSERVICO")
    SituacaoEnum situacaoServico;

    @OneToOne()
    @JoinColumn(name = "ORCAMENTOSERVICO", nullable = false)
    Orcamento orcamentoServico;

    @Column(name = "DTINSTALACAO")
    Date dataInstalacaoServico;

    @Column(name = "OBSSERVICO")
    String observacaoServico;

}
