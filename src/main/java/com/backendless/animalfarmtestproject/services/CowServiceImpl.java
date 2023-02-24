package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GrassModel;
import com.backendless.animalfarmtestproject.models.Vegetable;
import com.backendless.animalfarmtestproject.repositories.CowRepository;
import com.backendless.animalfarmtestproject.repositories.GrassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service(value = "cowService")
@AllArgsConstructor
public class CowServiceImpl implements HerbivorousService<CowModel> {
    private CowRepository cowRepository;
    private GrassRepository grassRepository;

    @Override
    public void eat(Vegetable food, CowModel eater) {
        eater.eat(food);

    }

    @Override
    public void createNewAnimal(String name) {
        CowModel cow = new CowModel();
        cow.setName(name);
        cowRepository.save(cow);
    }

    @Override
    public CowModel getAnimalByName(String name) {
        return cowRepository.getCowModelByName(name).orElseThrow();
    }

    public void feedAnimal(String name) {
        CowModel cow = getAnimalByName(name);
        eat(new GrassModel(), cow);
    }
}
