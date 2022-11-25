package br.com.atividade.sistemas.distribuidos.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atividade.sistemas.distribuidos.dto.AlunoDto;
import br.com.atividade.sistemas.distribuidos.entity.Aluno;
import br.com.atividade.sistemas.distribuidos.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repository;

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) throws Exception {
        Optional<Aluno> aluno = repository.findById(id);

        if (!aluno.isPresent()) {
            throw new Exception("Id não encontrado");
        }

        return aluno.get();
    }

    @GetMapping
    public List<Aluno> listaAlunos() {
        return repository.findAll();
    }

    @GetMapping("/curso/{nomeCurso}")
    public List<Aluno> listarAlunosPorCurso(@PathVariable String nomeCurso) {
        return repository.findByCurso(nomeCurso);
    }

    @Transactional
    @PostMapping
    public Aluno adicionarAluno(@RequestBody AlunoDto dto) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(dto, aluno);
        repository.save(aluno);
        return aluno;
    }

    @Transactional
    @PutMapping("/{id}")
    public Aluno atualizarDadosAluno(@PathVariable Long id, @RequestBody AlunoDto dto) throws Exception {
        Optional<Aluno> aluno = repository.findById(id);
        
        if (!aluno.isPresent()) {
            throw new Exception("Id não encontrado");
        }

        Aluno atualiza = repository.getReferenceById(id);

        BeanUtils.copyProperties(dto, atualiza);
        repository.save(atualiza);
        return atualiza;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> removerAluno(@PathVariable Long id) throws Exception {
        Optional<Aluno> aluno = repository.findById(id);

        if (!aluno.isPresent()) {
            throw new Exception("Id não encontrado");
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
