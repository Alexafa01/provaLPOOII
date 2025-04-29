package com.example.prova.repositorio;

import com.example.prova.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long> {
}
