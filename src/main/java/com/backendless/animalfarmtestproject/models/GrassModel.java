package com.backendless.animalfarmtestproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grass")
@Setter
@Getter
public class GrassModel extends Vegetable {


}
