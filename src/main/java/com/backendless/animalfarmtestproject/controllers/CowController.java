package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.services.HerbivorousService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cows")
@AllArgsConstructor
public class CowController {
    private HerbivorousService<CowModel> cowService;

    @GetMapping
    public ResponseEntity<CowModel> getCow(@RequestParam String name) {
        return ResponseEntity.ok(cowService.getAnimalByName(name));
    }

    @PostMapping
    public ResponseEntity<String> createNewCow(@RequestParam String name) {
        cowService.createNewAnimal(name);
        return ResponseEntity.ok(String.format("New cow %s created", name));
    }
}
