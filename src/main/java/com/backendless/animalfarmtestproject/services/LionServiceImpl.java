package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.exceptions.AnimalException;
import com.backendless.animalfarmtestproject.exceptions.FeedErrors;
import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.LionModel;
import com.backendless.animalfarmtestproject.models.Meat;
import com.backendless.animalfarmtestproject.repositories.LionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lionService")
@AllArgsConstructor
public class LionServiceImpl implements CarnivorousService<LionModel> {

    private LionRepository lionRepository;

    private HerbivorousService<CowModel> cowService;

    private HerbivorousService<GoatModel> goatService;

    @Override
    public void eat(Meat food, LionModel lionModel) {
        if (food.getLion() == null) {
            food.eaten(lionModel);
            lionModel.eat(food);
            lionRepository.save(lionModel);
        } else {
            throw new AnimalException(FeedErrors.ANIMAL_ALREADY_EATEN, food);
        }
    }

    @Override
    public List<LionModel> getAllAnimals() {
        return lionRepository.findAll();
    }

    @Override
    public void createNewAnimal(String name) {
        LionModel lion = new LionModel();
        lion.setName(name);
        lionRepository.save(lion);
    }


    @Override
    public LionModel getAnimalByName(String name) {
        return lionRepository.getLionModelByName(name)
            .orElseThrow(() -> new AnimalException(FeedErrors.ANIMAL_DOESNT_EXIST, name, "lion"));
    }

    @Override
    public void feedLion(String lionName, String foodName, String foodType) {
        LionModel lion = getAnimalByName(lionName);
        switch (foodType) {
            case "cow" -> eat(cowService.getAnimalByName(foodName), lion);
            case "goat" -> eat(goatService.getAnimalByName(foodName), lion);
        }
    }
}
