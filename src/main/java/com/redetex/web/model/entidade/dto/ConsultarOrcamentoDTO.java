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
import java.util.Objects;

@Data
@NoArgsConstructor
public class ConsultarOrcamentoDTO {

    Long idOrcamento;
    TipoEnum tipoOrcamento;
    SituacaoEnum situacaoOrcamento;
    Cliente clienteOrcamento;
    Endereco enderecoOrcamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "America/Recife")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dataInicialOrcamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "America/Recife")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dataFinalOrcamento;

    @Builder
    public ConsultarOrcamentoDTO(
            Long idOrcamento,
            TipoEnum tipoOrcamento,
            SituacaoEnum situacaoOrcamento,
            Cliente clienteOrcamento,
            Endereco enderecoOrcamento,
            Date dataInicialOrcamento,
            Date dataFinalOrcamento
    ) {
        this.idOrcamento = idOrcamento;
        this.tipoOrcamento = tipoOrcamento;
        this.situacaoOrcamento = situacaoOrcamento;
        this.clienteOrcamento = clienteOrcamento;
        this.enderecoOrcamento = enderecoOrcamento;
        this.dataInicialOrcamento = dataInicialOrcamento;
        this.dataFinalOrcamento = dataFinalOrcamento;
    }

    public boolean isNull() {
        return Objects.isNull(idOrcamento)
            && Objects.isNull(tipoOrcamento)
            && Objects.isNull(situacaoOrcamento)
            && Objects.isNull(clienteOrcamento.getTelefoneCliente())
            && Objects.isNull(clienteOrcamento.getNomeCliente())
            && Objects.isNull(enderecoOrcamento.getCepRua())
            && Objects.isNull(enderecoOrcamento.getNomeRua())
            && Objects.isNull(enderecoOrcamento.getNomeEdificio())
            && Objects.isNull(enderecoOrcamento.getBairro())
            && Objects.isNull(dataInicialOrcamento)
            && Objects.isNull(dataFinalOrcamento);
    }
}
