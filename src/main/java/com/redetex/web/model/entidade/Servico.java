package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Servico {

    int idServico;
    int situacaoServico;
    Orcamento orcamentoServico;
    Date dataInstalacaoServico;
    String observacaoServico;

}
