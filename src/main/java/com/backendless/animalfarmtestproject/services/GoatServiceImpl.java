package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.Vegetable;
import com.backendless.animalfarmtestproject.repositories.GoatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service(value = "goatService")
@AllArgsConstructor
public class GoatServiceImpl implements HerbivorousService<GoatModel> {

    private GoatRepository goatRepository;

    @Override
    public void eat(Vegetable food, GoatModel eater) {
        eater.eat(food);

    }

    @Override
    public void createNewAnimal(String name) {
        GoatModel goat = new GoatModel();
        goat.setName(name);
        goatRepository.save(goat);

    }

    @Override
    public GoatModel getAnimalByName(String name) {
        return goatRepository.getGoatModelByName(name).orElseThrow();
    }
}
