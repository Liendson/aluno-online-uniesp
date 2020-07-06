package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.enums.SituacaoClienteEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

    int idCliente;
    String nomeCliente;
    String telefoneCliente;
    SituacaoClienteEnum situacao;

}
