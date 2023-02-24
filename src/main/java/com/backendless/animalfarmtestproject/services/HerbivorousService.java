package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.Herbivorous;
import com.backendless.animalfarmtestproject.models.Vegetable;

import java.util.List;

public interface HerbivorousService<T extends Herbivorous> extends AnimalService<Vegetable, T> {
    T getAnimalByName(String name);

    List<T> getAllAnimals();

    void feedAnimal(String name);
}
