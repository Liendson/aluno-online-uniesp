package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Endereco {

    String nomeRua;
    String bairro;
    String cepRua;
    String nomeEdificio;
    int apartamentoEdificio;
    int numeroEdificio;

}
