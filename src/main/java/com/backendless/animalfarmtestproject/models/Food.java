package com.backendless.animalfarmtestproject.models;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Food<T extends Animal> {

    abstract void eaten(T eater);
}
