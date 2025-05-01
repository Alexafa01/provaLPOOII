package com.example.prova.controller;

import com.example.prova.model.Agendamento;
import com.example.prova.repositorio.AgendamentoRepositorio;
import com.example.prova.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private AgendamentoRepositorio agendamentoRepositorio;

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscar(@PathVariable Long id) {
        return ResponseEntity.of(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(service.atualizar(id, agendamento));
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento) {

        agendamento.setDataHora(LocalDateTime.now());
        return ResponseEntity.ok(service.salvar(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

