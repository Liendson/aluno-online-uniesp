package com.redetex.web.model.entidade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDTO {

    String nomeRua;
    String bairro;
    String cepRua;
    String nomeEdificio;
    int apartamentoEdificio;
    int numeroEdificio;

}
