package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.models.CowModel;
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
@RequestMapping("cows")
@AllArgsConstructor
public class CowController {
    private HerbivorousService<CowModel> cowService;

    @GetMapping("/{name}")
    public ResponseEntity<CowModel> getCow(@PathVariable String name) {
        return ResponseEntity.ok(cowService.getAnimalByName(name));
    }

    @GetMapping
    public ResponseEntity<List<CowModel>> getCows() {
        return ResponseEntity.ok(cowService.getAllAnimals());
    }

    @PostMapping
    public ResponseEntity<String> createNewCow(@RequestParam String name) {
        cowService.createNewAnimal(name);
        return ResponseEntity.ok(String.format("New cow %s created", name));
    }

    @PutMapping("/feed")
    public ResponseEntity<String> feedCow(@RequestParam String name) {
        cowService.feedAnimal(name);
        return ResponseEntity.ok(String.format("Cow %s fed", name));
    }
}
