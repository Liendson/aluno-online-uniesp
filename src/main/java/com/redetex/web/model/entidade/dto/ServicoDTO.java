package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.enums.SituacaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ServicoDTO {

    int idServico;
    SituacaoEnum situacaoServico;
    OrcamentoDTO orcamentoServico;
    Date dataInstalacaoServico;
    String observacaoServico;

}
