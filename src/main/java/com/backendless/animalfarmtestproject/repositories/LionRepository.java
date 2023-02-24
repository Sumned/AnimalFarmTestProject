package com.backendless.animalfarmtestproject.repositories;

import com.backendless.animalfarmtestproject.models.LionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LionRepository extends CrudRepository<LionModel, Long> {

    Optional<LionModel> getLionModelByName(String name);
}
