package com.example.prova.model;

import jakarta.persistence.*;

@Table
@Entity
public class Pet {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String raca;

    @Column
    private String cor;
    
    @Column
    private String genero;

    @Column
    private String proprietario;

    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;

    public Pet() {
    }

    public Pet(String raca, String cor, String genero, String proprietario, Agendamento agendamento) {
        this.raca = raca;
        this.cor = cor;
        this.genero = genero;
        this.proprietario = proprietario;
        this.agendamento = agendamento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}
