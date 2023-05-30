package com.alunoonline.api.model.entidade.dto;

import com.alunoonline.api.model.entidade.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDisciplinaDTO {

    private Long id;

    private String nome;

    private Double primeiraNota;

    private Double segundaNota;

    private Double media;

    private String status;
}
