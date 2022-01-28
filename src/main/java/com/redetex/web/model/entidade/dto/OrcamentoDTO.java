package com.redetex.web.model.entidade.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Endereco;
import com.redetex.web.model.entidade.Medida;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import com.redetex.web.model.utilities.CustomJsonDateDeserializer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class OrcamentoDTO {

    Long idOrcamento;
    TipoEnum tipoOrcamento;
    SituacaoEnum situacaoOrcamento;
    Cliente clienteOrcamento;
    Endereco enderecoOrcamento;
    Medida medidasOrcamento;
    Float valorOrcamento;
    String observacaoOrcamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "America/Recife")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dataOrcamento;

    @Builder
    public OrcamentoDTO(
        Long idOrcamento,
        TipoEnum tipoOrcamento,
        SituacaoEnum situacaoOrcamento,
        Cliente clienteOrcamento,
        Endereco enderecoOrcamento,
        Float valorOrcamento,
        Medida medidasOrcamento,
        String observacaoOrcamento,
        Date dataOrcamento
    ) {
        this.idOrcamento = idOrcamento;
        this.tipoOrcamento = tipoOrcamento;
        this.situacaoOrcamento = situacaoOrcamento;
        this.clienteOrcamento = clienteOrcamento;
        this.enderecoOrcamento = enderecoOrcamento;
        this.valorOrcamento = valorOrcamento;
        this.medidasOrcamento = medidasOrcamento;
        this.observacaoOrcamento = observacaoOrcamento;
        this.dataOrcamento = dataOrcamento;
    }

}
