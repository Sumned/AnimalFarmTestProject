package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.exceptions.AnimalException;
import com.backendless.animalfarmtestproject.exceptions.FeedErrors;
import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GrassModel;
import com.backendless.animalfarmtestproject.models.Meat;
import com.backendless.animalfarmtestproject.models.Vegetable;
import com.backendless.animalfarmtestproject.repositories.CowRepository;
import com.backendless.animalfarmtestproject.repositories.GrassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "cowService")
@AllArgsConstructor
public class CowServiceImpl implements HerbivorousService<CowModel> {
    private CowRepository cowRepository;

    private GrassRepository grassRepository;

    @Override
    public void eat(Vegetable food, CowModel eater) {
        food.setCowEater(eater);
        eater.eat(food);
        cowRepository.save(eater);
    }

    @Override
    public void createNewAnimal(String name) {
        CowModel cow = new CowModel();
        cow.setName(name);
        cowRepository.save(cow);
    }

    @Override
    public CowModel getAnimalByName(String name) {
        CowModel cowModel = cowRepository.getCowModelByName(name)
            .orElseThrow(() -> new AnimalException(FeedErrors.ANIMAL_DOESNT_EXIST, name, "cow"));
        cowModel.eatenBy();
        return cowModel;
    }

    @Override
    public List<CowModel> getAllAnimals() {
        List<CowModel> cows = cowRepository.findAll();
        cows.forEach(Meat::eatenBy);
        return cows;
    }

    @Override
    public void feedAnimal(String name) {
        CowModel cow = getAnimalByName(name);
        if (cow.getLion() == null) {
            eat(grassRepository.save(new GrassModel()), cow);
        } else {
            throw new AnimalException(FeedErrors.ANIMAL_ALREADY_EATEN, cow);
        }
    }
}
