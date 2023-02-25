package com.backendless.animalfarmtestproject.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class Vegetable extends Food<Herbivorous> {

    @ManyToOne
    @JoinColumn(name = "cow_id")
    @JsonIgnore
    private CowModel cowEater;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    @JsonIgnore
    private GoatModel goatEater;

    @Column(name = "creating_date", insertable = false, updatable = false)
    private LocalDateTime creatingDate;

    @Override
    void eaten(Herbivorous eater) {
        if (eater instanceof CowModel) {
            cowEater = (CowModel) eater;
        } else {
            goatEater = (GoatModel) eater;
        }
    }
}
