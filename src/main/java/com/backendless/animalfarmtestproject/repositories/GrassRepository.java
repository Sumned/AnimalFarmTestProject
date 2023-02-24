package com.backendless.animalfarmtestproject.repositories;

import com.backendless.animalfarmtestproject.models.GrassModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrassRepository extends CrudRepository<GrassModel, Long> {
}
