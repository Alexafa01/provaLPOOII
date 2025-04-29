package com.example.prova.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prova.model.Pet;

@Repository
public interface PetRepositorio extends JpaRepository<Pet, Integer>{

    
}
