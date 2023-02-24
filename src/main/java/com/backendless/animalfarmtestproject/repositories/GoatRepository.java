package com.backendless.animalfarmtestproject.repositories;

import com.backendless.animalfarmtestproject.models.GoatModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoatRepository extends CrudRepository<GoatModel, Long> {
    Optional<GoatModel> getGoatModelByName(String name);

    @Override
    List<GoatModel> findAll();
}
