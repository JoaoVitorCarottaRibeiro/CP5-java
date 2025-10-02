package com.fiap.restapi.service;

import com.fiap.restapi.model.Professor;
import com.fiap.restapi.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ProfessorService {

    private final ProfessorRepository repo;

    public ProfessorService(ProfessorRepository repo) {
        this.repo = repo;
    }

    public Professor adicionar(String nome, String departamento, String email, String titulacao) {
        validar(nome, departamento, email, titulacao);
        Professor p = new Professor(null, nome.trim(), departamento.trim(), email.trim(), titulacao != null ? titulacao.trim() : null);
        return repo.adicionar(p);
    }

    public Optional<Professor> buscarPorId(Long id) {
        validarId(id);
        return repo.buscarPorId(id);
    }

    public List<Professor> listar() {
        return repo.listar();
    }

    public Optional<Professor> atualizar(Long id, String nome, String departamento, String email, String titulacao) {
        validarId(id);
        validar(nome, departamento, email, titulacao);
        Professor p = new Professor(id, nome.trim(), departamento.trim(), email.trim(), titulacao != null ? titulacao.trim() : null);
        return repo.atualizar(id, p);
    }

    public boolean deletar(Long id) {
        validarId(id);
        return repo.deletar(id);
    }

    private void validar(String nome, String departamento, String email, String titulacao) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome é obrigatório");
        if (departamento == null || departamento.trim().isEmpty()) throw new IllegalArgumentException("Departamento é obrigatório");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email é obrigatório");
        if (!Pattern.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$", email)) throw new IllegalArgumentException("Email inválido");
        if (titulacao != null && titulacao.length() > 80) throw new IllegalArgumentException("Titulação deve ter até 80 caracteres");
    }

    private void validarId(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("ID inválido");
    }
}

