package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Endereco;
import com.redetex.web.model.entidade.Medida;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrcamentoDTO {

    int idOrcamento;
    TipoEnum tipoOrcamento;
    SituacaoEnum situacaoOrcamento;
    Cliente clienteOrcamento;
    Endereco enderecoOrcamento;
    Medida medidasOrcamento;
    Float valorOrcamento;
    String observacaoOrcamento;

    @Builder
    public OrcamentoDTO(
        int idOrcamento,
        TipoEnum tipoOrcamento,
        SituacaoEnum situacaoOrcamento,
        Cliente clienteOrcamento,
        Endereco enderecoOrcamento,
        Float valorOrcamento,
        Medida medidasOrcamento,
        String observacaoOrcamento
    ) {
        this.idOrcamento = idOrcamento;
        this.tipoOrcamento = tipoOrcamento;
        this.situacaoOrcamento = situacaoOrcamento;
        this.clienteOrcamento = clienteOrcamento;
        this.enderecoOrcamento = enderecoOrcamento;
        this.valorOrcamento = valorOrcamento;
        this.medidasOrcamento = medidasOrcamento;
        this.observacaoOrcamento =observacaoOrcamento;
    }

}
