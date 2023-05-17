package com.alunoonline.api.model.repository;

import com.alunoonline.api.model.entidade.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
