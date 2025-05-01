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

    public Pet pegarPet(String id) {
        Optional<Pet> petExistente = petRepositorio.findById(Long.parseLong(id));

        if (!petExistente.isPresent()) {
            throw new RuntimeException("Pet não encontrado com ID: " + id);
        }

        return petExistente.get();
    }

    public Pet atualizarPet(String id, Pet pet) {

        Optional<Pet> petExistente = petRepositorio.findById(Long.parseLong(id));

        if (!petExistente.isPresent()) {
            throw new RuntimeException("Pet não encontrado com ID: " + id);
        }

        if(pet.getRaca() != null){
            petExistente.get().setRaca(pet.getRaca());
        }
        if(pet.getCor() != null){
            petExistente.get().setCor(pet.getCor());
        }
        if(pet.getGenero() != null){
            petExistente.get().setGenero(pet.getGenero());
        }
        if(pet.getProprietario() != null){
            petExistente.get().setProprietario(pet.getProprietario());
        }

        return petRepositorio.save(petExistente.get());
    }

    public void deletarPet(String id, Pet pet) {
        Optional<Pet> petExistente = petRepositorio.findById(Long.parseLong(id));

        if (!petExistente.isPresent()) {
            throw new RuntimeException("Pet não encontrado com ID: " + id);
        }

        petRepositorio.deleteById(Long.parseLong(id));
    }
}
