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

import java.util.List;

@Entity
@Table(name = "goats")
@Setter
@Getter
public class GoatModel extends Meat implements Herbivorous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "goatEater")
    private List<GrassModel> grass;


    @Override
    public void eat(Vegetable food) {
        grass.add((GrassModel) food);

    }
}
