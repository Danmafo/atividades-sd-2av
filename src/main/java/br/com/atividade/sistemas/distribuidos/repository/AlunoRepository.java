package br.com.atividade.sistemas.distribuidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atividade.sistemas.distribuidos.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    List<Aluno> findByCurso(String curso);

}
