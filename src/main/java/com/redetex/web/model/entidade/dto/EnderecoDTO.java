package com.redetex.web.model.entidade.dto;

import lombok.Builder;
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

    @Builder
    public EnderecoDTO(
        String nomeRua,
        String bairro,
        String cepRua,
        String nomeEdificio,
        int apartamentoEdificio,
        int numeroEdificio
    ) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.cepRua = cepRua;
        this.nomeEdificio = nomeEdificio;
        this.apartamentoEdificio = apartamentoEdificio;
        this.numeroEdificio = numeroEdificio;
    }

}
