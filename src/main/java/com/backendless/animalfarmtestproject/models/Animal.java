package com.backendless.animalfarmtestproject.models;

public interface Animal<T extends Food> {
    void eat(T food);
}
