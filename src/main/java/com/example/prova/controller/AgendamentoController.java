package com.example.prova.controller;

import com.example.prova.controller.dto.AtualizarAgendametoDTO;
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
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscar(@PathVariable String id) {
        return ResponseEntity.of(agendamentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento) {

        Agendamento novoAgendamento = agendamentoService.novoAgendamento(agendamento);

        return ResponseEntity.ok(novoAgendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable String id,
                                                 @RequestBody AtualizarAgendametoDTO agendamentoDTO) {
        Agendamento agendamento = agendamentoService.atualizar(id, agendamentoDTO);

        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

