package com.redetex.web.model.entidade;

import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "TB_SERVICOS")
@NoArgsConstructor
public class Servico {

    @Column(name = "IDSERVICO")
    int idServico;

    @Column(name = "SITSERVICO")
    SituacaoEnum situacaoServico;

    @Column(name = "ORCAMENTOSERVICO")
    Orcamento orcamentoServico;

    @Column(name = "DTINSTALACAO")
    Date dataInstalacaoServico;

    @Column(name = "OBSSERVICO")
    String observacaoServico;

}
