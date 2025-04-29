package com.example.prova.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova.model.Pet;
import com.example.prova.service.PetService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<Pet> inserirPets(@RequestBody Pet pet) {

        Pet petData = petService.savePetData(pet);
        return new ResponseEntity(petData, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> buscarPet() {
        List<Pet> pets = petService.pegarTodosPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/:id")
    public ResponseEntity<List<Pet>> buscarPetPorId(@RequestParam int id) {
        Pet pets = petService.pegarPet(id);
        return new ResponseEntity(pets, HttpStatus.OK);
    }

    @PutMapping("/:id")
    public ResponseEntity<Pet> atualizarPets(@RequestParam int id, @RequestBody Pet pet) {
        Pet pets = petService.atualizarPet(id, pet);
        return new ResponseEntity(pets, HttpStatus.OK);
    }

    @DeleteMapping("/:id")
    public void deletarPets(@RequestParam int id, @RequestBody Pet pet) {
        petService.deletarPet(id, pet);

    }

}
