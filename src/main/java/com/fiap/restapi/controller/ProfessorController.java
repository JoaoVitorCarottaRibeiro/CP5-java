package com.fiap.restapi.controller;

import com.fiap.restapi.model.Aluno;
import com.fiap.restapi.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/professores")

private final ProfessorService service;

public ProfessorController(ProfessorService service) { this.service = service; }

@PostMapping
public ResponseEntity<Professor> criar(@RequestBody Professor dto) { /* 201 + Location */ }

@GetMapping
public List<Professor> listar() { /* 200 */ }

@GetMapping("/{id}")
public ResponseEntity<Professor> buscar(@PathVariable Long id) { /* 200/404 */ }

@PutMapping("/{id}")
public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor dto) { /* 200/400/404 */ }

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) { /* 204/404 */ }
}
