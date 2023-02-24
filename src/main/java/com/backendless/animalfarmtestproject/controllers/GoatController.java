package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.services.HerbivorousService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goats")
@AllArgsConstructor
public class GoatController {
    private HerbivorousService<GoatModel> goatService;

    @GetMapping("/goat")
    public ResponseEntity<GoatModel> getGoat(@RequestParam String name) {
        return ResponseEntity.ok(goatService.getAnimalByName(name));
    }

    @GetMapping
    public ResponseEntity<List<GoatModel>> getGoats() {
        return ResponseEntity.ok(goatService.getAllAnimals());
    }

    @PostMapping
    public ResponseEntity<String> createNewGoat(@RequestParam String name) {
        goatService.createNewAnimal(name);
        return ResponseEntity.ok(String.format("New cow %s created", name));
    }

    @PutMapping("/feed")
    public ResponseEntity<String> feedGoat(@RequestParam String name) {
        goatService.feedAnimal(name);
        return ResponseEntity.ok(String.format("Cow %s fed", name));
    }

}
