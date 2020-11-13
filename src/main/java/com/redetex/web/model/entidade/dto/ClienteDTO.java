package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.enums.SituacaoClienteEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

    Long idCliente;
    String nomeCliente;
    String telefoneCliente;
    SituacaoClienteEnum situacao;

    @Builder
    public ClienteDTO(
        Long idCliente,
        String nomeCliente,
        String telefoneCliente,
        SituacaoClienteEnum situacao
    ) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.situacao = situacao;
    }

}
