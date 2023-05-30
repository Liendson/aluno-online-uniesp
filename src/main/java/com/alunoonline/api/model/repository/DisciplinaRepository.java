package com.alunoonline.api.model.repository;

import com.alunoonline.api.model.entidade.Disciplina;
import com.alunoonline.api.model.entidade.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findAllByProfessor(Professor professor);
}
