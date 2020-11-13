package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.enums.SituacaoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ServicoDTO {

    Long idServico;
    SituacaoEnum situacaoServico;
    Orcamento orcamentoServico;
    Date dataInstalacaoServico;
    String observacaoServico;

    @Builder
    public ServicoDTO(
        Long idServico,
        SituacaoEnum situacaoServico,
        Orcamento orcamentoServico,
        Date dataInstalacaoServico,
        String observacaoServico
    ) {
        this.idServico = idServico;
        this.situacaoServico = situacaoServico;
        this.orcamentoServico = orcamentoServico;
        this.dataInstalacaoServico = dataInstalacaoServico;
        this.observacaoServico = observacaoServico;
    }

}
