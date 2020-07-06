package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrcamentoDTO {

    int idOrcamento;
    TipoEnum tipoOrcamento;
    SituacaoEnum situacaoOrcamento;
    ClienteDTO clienteOrcamento;
    EnderecoDTO enderecoOrcamento;
    MedidaDTO medidasOrcamento;
    Float valorOrcamento;
    String observacaoOrcamento;

}
