package com.backendless.animalfarmtestproject.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Food<T extends Animal> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_generator")
    @SequenceGenerator(name = "t_generator", sequenceName = "TABLE_SEQUENCE", initialValue = 50)
    private Long id;

    abstract void eaten(T eater);
}
