package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    int idCliente;
    String nomeCliente;
    String telefoneCliente;

}
