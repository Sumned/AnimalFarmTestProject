package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.Animal;
import com.backendless.animalfarmtestproject.models.Food;

import java.util.List;

public interface AnimalService<T extends Food, X extends Animal> {
    void eat(T food, X eater);

    List<X> getAllAnimals();

    void createNewAnimal(String name);
}
