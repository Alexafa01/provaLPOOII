package com.example.prova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private String propietario;

    public String getCor() {
        return cor;
    }
    public String getGenero() {
        return genero;
    }
    public int getId() {
        return id;
    }
    public String getPropietario() {
        return propietario;
    }
    public String getRaca() {
        return raca;
    }
    public void setId(int id) {
        this.id = id;
    }
}