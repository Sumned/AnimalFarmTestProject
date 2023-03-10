package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.models.LionModel;
import com.backendless.animalfarmtestproject.services.CarnivorousService;
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
@RequestMapping(("/lions"))
@AllArgsConstructor
public class LionController {

    private CarnivorousService<LionModel> lionService;

    @GetMapping("/{name}")
    public ResponseEntity<LionModel> getLion(@PathVariable String name) {
        return ResponseEntity.ok(lionService.getAnimalByName(name));
    }

    @GetMapping
    public ResponseEntity<List<LionModel>> getLions() {
        return ResponseEntity.ok(lionService.getAllAnimals());
    }


    @PostMapping("/{name}")
    public ResponseEntity<String> createNewLion(@PathVariable String name) {
        lionService.createNewAnimal(name);
        return ResponseEntity.ok(String.format("New lion %s created", name));
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> feedLion(@PathVariable String name,
                                           @RequestParam String foodName,
                                           @RequestParam String foodType) {
        lionService.feedLion(name, foodName, foodType);
        return ResponseEntity.ok(String.format("Lion %s fed by %S", name, foodName));
    }
}
