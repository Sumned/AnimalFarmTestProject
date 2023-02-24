package com.backendless.animalfarmtestproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
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
public abstract class Meat extends Food<Carnivorous> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_generator")
    @SequenceGenerator(name = "t_generator", sequenceName = "TABLE_SEQUENCE", initialValue = 50)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "lion_id")
    @JsonIgnore
    private LionModel lion;

    @Override
    public void eaten(Carnivorous eater) {
        lion = (LionModel) eater;
    }
}
