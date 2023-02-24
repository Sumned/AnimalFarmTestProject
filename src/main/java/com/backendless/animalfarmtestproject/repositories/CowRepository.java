package com.backendless.animalfarmtestproject.repositories;

import com.backendless.animalfarmtestproject.models.CowModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CowRepository extends CrudRepository<CowModel, Long> {

    Optional<CowModel> getCowModelByName(String name);
}
