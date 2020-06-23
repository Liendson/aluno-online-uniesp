package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.entidade.Orcamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ServicoDTO {

    int idServico;
    int situacaoServico;
    Orcamento orcamentoServico;
    Date dataInstalacaoServico;
    String observacaoServico;

}
