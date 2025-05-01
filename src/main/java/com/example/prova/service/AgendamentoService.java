package com.example.prova.service;

import com.example.prova.controller.dto.AtualizarAgendametoDTO;
import com.example.prova.model.Agendamento;
import com.example.prova.model.Pet;
import com.example.prova.repositorio.AgendamentoRepositorio;
import com.example.prova.repositorio.PetRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepositorio agendamentoRepository;

    @Autowired
    private PetRepositorio petRepositorio;

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(String id) {
        return agendamentoRepository.findById(Long.parseLong(id));
    }

    public Agendamento novoAgendamento(Agendamento agendamento) {
        Optional<Pet> petExistente = petRepositorio.findById(agendamento.getPet().getId());

        if(!petExistente.isPresent()){
            throw new RuntimeException("ID de pet inexistente");
        }

        agendamento.setDataHora(LocalDateTime.now());
        agendamento.setPet(petExistente.get());

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(String id, AtualizarAgendametoDTO agendamento) {
        Optional<Agendamento> agendamentoExistente = agendamentoRepository.findById(Long.parseLong(id));

        if(!agendamentoExistente.isPresent()){
            throw new RuntimeException("Agendamento não encontrado com ID:" + id);
        }

        if(agendamento.tipoServico() != null){
            agendamentoExistente.get().setTipoServico(agendamento.tipoServico());
        }

        return agendamentoRepository.save(agendamentoExistente.get());
    }

    public void deletar(String id) {
        Optional<Agendamento> existente = agendamentoRepository.findById(Long.parseLong(id));
        if (existente.isPresent()) {
            agendamentoRepository.deleteById(Long.parseLong(id));
        } else {
            throw new RuntimeException("Agendamento não encontrado com ID: " + id);
        }
    }
}
