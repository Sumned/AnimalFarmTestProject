package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.LionModel;
import com.backendless.animalfarmtestproject.models.Meat;
import com.backendless.animalfarmtestproject.repositories.LionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("lionService")
@AllArgsConstructor
public class LionServiceImpl implements CarnivorousService<LionModel> {

    private LionRepository lionRepository;

    private HerbivorousService<CowModel> cowService;

    private HerbivorousService<GoatModel> goatService;

    @Override
    public void eat(Meat food, LionModel lionModel) {
        if (food.getLion() != null) {
            food.eaten(lionModel);
            lionModel.eat(food);
            lionRepository.save(lionModel);
        }
    }

    @Override
    public void createNewAnimal(String name) {
        LionModel lion = new LionModel();
        lion.setName(name);
        lionRepository.save(lion);
    }

    @Override
    public LionModel getLionByName(String name) {
        return lionRepository.getLionModelByName(name).orElseThrow();
    }

    @Override
    public void feedLion(String lionName, String foodName, String foodType) {
        LionModel lion = getLionByName(lionName);
        switch (foodType) {
            case "cow" -> eat(cowService.getAnimalByName(foodName), lion);
            case "goat" -> eat(goatService.getAnimalByName(foodName), lion);
        }
    }
}
