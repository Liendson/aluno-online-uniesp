package com.alunoonline.api.model.entidade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarNotasDTO {

    private Long idMatriculaAluno;

    private Double primeiraNota;

    private Double segundaNota;
}
