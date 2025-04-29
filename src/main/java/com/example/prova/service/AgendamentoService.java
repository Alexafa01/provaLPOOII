package com.example.prova.service;

import com.example.prova.model.Agendamento;
import com.example.prova.repositorio.AgendamentoRepositorio;
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


    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public Agendamento agendar(Agendamento agendamento) {
        agendamento.setDataHora(LocalDateTime.now());
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento atualizar(Long id, Agendamento novoAgendamento) {
        return agendamentoRepository.findById(id)
                .map(ag -> {
                    ag.setDataHora(novoAgendamento.getDataHora());
                    ag.setTipoServico(novoAgendamento.getTipoServico());
                    ag.setNomePet(novoAgendamento.getNomePet());
                    return agendamentoRepository.save(ag);
                }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void cancelar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public double calcularValor(Agendamento agendamento) {
        LocalDateTime inicio = agendamento.getDataHora();
        LocalDateTime fim = LocalDateTime.now();
        long minutos = Duration.between(inicio, fim).toMinutes();

        if (minutos <= 15) {
            return 0.0;
        }

        long horas = (long) Math.ceil((double) minutos / 60);
        return horas * 10.0;
    }

    public void deletar(Long id) {
        // Você pode verificar se o agendamento existe antes de deletar
        Optional<Agendamento> existente = agendamentoRepository.findById(id);
        if (existente.isPresent()) {
            agendamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Agendamento não encontrado com ID: " + id);
        }
    }
}
