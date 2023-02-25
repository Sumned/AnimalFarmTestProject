package com.backendless.animalfarmtestproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class Meat extends Food<Carnivorous> {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lion_id")
    @JsonIgnore
    private LionModel lion;

    @Column(name = "creating_date", insertable = false, updatable = false)
    private LocalDateTime creatingDate;

    @Column(name = "last_modification_date", insertable = false, updatable = false)
    private LocalDateTime lastModificationDate;

    @Transient
    private String eatenBy;

    @Override
    public void eaten(Carnivorous eater) {
        lion = (LionModel) eater;
    }

    public void eatenBy() {
        if (lion != null) {
            eatenBy = lion.getName();
        }
    }
}
