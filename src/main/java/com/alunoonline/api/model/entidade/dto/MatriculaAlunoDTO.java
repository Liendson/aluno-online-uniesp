package com.alunoonline.api.model.entidade.dto;

import com.alunoonline.api.model.entidade.Aluno;
import com.alunoonline.api.model.entidade.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaAlunoDTO {


    private Long id;

    private Double nota1;

    private Double nota2;

    private Aluno aluno;

    private Disciplina disciplina;

    private String status;

}
