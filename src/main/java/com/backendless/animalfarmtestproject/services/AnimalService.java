package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.Animal;
import com.backendless.animalfarmtestproject.models.Food;

public interface AnimalService<T extends Food, X extends Animal> {
    void eat(T food, X eater);

    void createNewAnimal(String name);
}
