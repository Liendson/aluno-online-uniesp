package com.alunoonline.api.model.repository;

import com.alunoonline.api.model.entidade.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {

    List<MatriculaAluno> findByAlunoId(Long alunoId);

}
