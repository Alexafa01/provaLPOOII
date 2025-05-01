package com.example.prova.controller;

import org.springframework.web.bind.annotation.*;

import com.example.prova.model.Pet;
import com.example.prova.service.PetService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> buscarPet() {
        List<Pet> pets = petService.pegarTodosPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPetPorId(@PathVariable String id) {
        Pet pet = petService.pegarPet(id);
        return new ResponseEntity(pet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> inserirPets(@RequestBody Pet pet) {

        Pet petData = petService.savePetData(pet);
        return new ResponseEntity(petData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizarPets(@PathVariable String id, @RequestBody Pet pet) {
        Pet pets = petService.atualizarPet(id, pet);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletarPets(@PathVariable String id, @RequestBody Pet pet) {
        petService.deletarPet(id, pet);

    }

}
