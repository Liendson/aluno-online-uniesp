package com.alunoonline.api.model.entidade.dto;

import com.alunoonline.api.model.entidade.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoAlunoDto {

    private String nomeAluno;

    private String cursoAluno;

    private List<HistoricoDisciplinaDTO> disciplinaDTOList;

}
