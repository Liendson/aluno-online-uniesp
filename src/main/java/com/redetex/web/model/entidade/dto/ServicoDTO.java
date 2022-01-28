package com.redetex.web.model.entidade.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.utilities.CustomJsonDateDeserializer;
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
    String observacaoServico;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "America/Recife")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dataInstalacaoServico;

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
