package com.backendless.animalfarmtestproject.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class Vegetable extends Food<Herbivorous> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_generator")
    @SequenceGenerator(name = "t_generator", sequenceName = "TABLE_SEQUENCE", initialValue = 50)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cow_id")
    private CowModel cowEater;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    private GoatModel goatEater;

    @Override
    void eaten(Herbivorous eater) {
        if (eater instanceof CowModel) {
            cowEater = (CowModel) eater;
        } else {
            goatEater = (GoatModel) eater;
        }
    }
}
