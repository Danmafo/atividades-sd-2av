package br.com.atividade.sistemas.distribuidos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AlunoDto {

    private String nome;
    private String curso;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    
    public AlunoDto() {
    }

    public AlunoDto(String nome, String curso, Date dataNascimento) {
        this.nome = nome;
        this.curso = curso;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    } 
    
}
