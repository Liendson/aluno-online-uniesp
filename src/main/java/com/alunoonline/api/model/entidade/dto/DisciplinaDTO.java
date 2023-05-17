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
public class DisciplinaDTO {

    private Long id;

    private String nome;

    private Professor professor;
}
