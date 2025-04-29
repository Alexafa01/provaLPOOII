package com.example.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova.model.Pet;
import com.example.prova.repositorio.PetRepositorio;

@Service
public class PetService {
    @Autowired
    PetRepositorio petRepositorio;

    public Pet savePetData(Pet pet) {
        return petRepositorio.save(pet);
    }

    public List<Pet> pegarTodosPets() {
        return petRepositorio.findAll();
    }

    public Pet pegarPet(int id) {
        return petRepositorio.getReferenceById(id);
    }

    public Pet atualizarPet(int id, Pet pet) {

        Optional<Pet> petExistente = petRepositorio.findById(id);

        if (!petExistente.isPresent()) {
            throw new RuntimeException("Pet não encontrado com ID: " + id);
        }

        pet.setId(id);
        return petRepositorio.save(pet);
    }

    public void deletarPet(int id, Pet pet) {
        Pet petdata = petRepositorio.getReferenceById(id);
        if (petdata == null) {
            new Exception("Pet não encontrado");
        }
        petRepositorio.deleteById(id);
    }
}
