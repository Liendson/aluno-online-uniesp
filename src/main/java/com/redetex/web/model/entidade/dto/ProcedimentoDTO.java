package com.redetex.web.model.entidade.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Endereco;
import com.redetex.web.model.entidade.Medida;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import com.redetex.web.model.enums.TipoProcedimentoEnum;
import com.redetex.web.model.utilities.CustomJsonDateDeserializer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProcedimentoDTO {

    Long id;
    TipoEnum tipoProduto;
    TipoProcedimentoEnum tipoProcedimento;
    SituacaoEnum situacao;
    Cliente cliente;
    Endereco endereco;
    Medida medidas;
    Float valor;
    String observacao;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss",
            locale = "pt-BR",
            timezone = "America/Recife")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    Date dataProcedimento;

    @Builder
    public ProcedimentoDTO(
            Long id,
            TipoEnum tipoProduto,
            TipoProcedimentoEnum tipoProcedimento,
            SituacaoEnum situacao,
            Cliente cliente,
            Endereco endereco,
            Medida medidas,
            Float valor,
            String observacao,
            Date dataProcedimento
    ) {
        this.id = id;
        this.tipoProduto = tipoProduto;
        this.tipoProcedimento = tipoProcedimento;
        this.situacao = situacao;
        this.cliente = cliente;
        this.endereco = endereco;
        this.medidas = medidas;
        this.valor = valor;
        this.observacao = observacao;
        this.dataProcedimento = dataProcedimento;
    }
}
