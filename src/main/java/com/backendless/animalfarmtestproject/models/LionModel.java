package com.backendless.animalfarmtestproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lions")
@Getter
@Setter
public class LionModel implements Carnivorous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "lion")
    private List<Meat> eaten;

    @Column(name = "creating_date", insertable = false, updatable = false)
    private LocalDateTime creatingDate;

    @Column(name = "last_modification_date", insertable = false, updatable = false)
    private LocalDateTime lastModificationDate;


    @Override
    public void eat(Meat food) {
        eaten.add(food);
    }
}
