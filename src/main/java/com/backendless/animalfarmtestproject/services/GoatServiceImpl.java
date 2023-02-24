package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.exceptions.AnimalException;
import com.backendless.animalfarmtestproject.exceptions.FeedErrors;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.Vegetable;
import com.backendless.animalfarmtestproject.repositories.GoatRepository;
import com.backendless.animalfarmtestproject.repositories.GrassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "goatService")
@AllArgsConstructor
public class GoatServiceImpl implements HerbivorousService<GoatModel> {

    private GoatRepository goatRepository;

    private GrassRepository grassRepository;

    @Override
    public void eat(Vegetable food, GoatModel eater) {
        food.setGoatEater(eater);
        eater.eat(food);
        goatRepository.save(eater);

    }

    @Override
    public void createNewAnimal(String name) {
        GoatModel goat = new GoatModel();
        goat.setName(name);
        goatRepository.save(goat);

    }

    @Override
    public GoatModel getAnimalByName(String name) {
        GoatModel goatModel = goatRepository.getGoatModelByName(name)
            .orElseThrow(() -> new AnimalException(FeedErrors.ANIMAL_DOESNT_EXIST, name, "goat"));
        goatModel.eatenBy();
        return goatRepository.getGoatModelByName(name).orElseThrow();
    }

    @Override
    public List<GoatModel> getAllAnimals() {
        List<GoatModel> goats = goatRepository.findAll();
        return null;
    }

    @Override
    public void feedAnimal(String name) {

    }


}
