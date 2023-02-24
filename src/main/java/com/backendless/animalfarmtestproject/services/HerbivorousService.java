package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.Herbivorous;
import com.backendless.animalfarmtestproject.models.Vegetable;

public interface HerbivorousService<T extends Herbivorous> extends AnimalService<Vegetable, T> {
    T getAnimalByName(String name);
}
