package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.Carnivorous;
import com.backendless.animalfarmtestproject.models.Meat;

public interface CarnivorousService<T extends Carnivorous> extends AnimalService<Meat, T> {
    void feedLion(String lionName, String foodName, String foodType);
}
