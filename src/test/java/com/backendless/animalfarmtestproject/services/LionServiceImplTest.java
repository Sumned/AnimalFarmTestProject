package com.backendless.animalfarmtestproject.services;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.LionModel;
import com.backendless.animalfarmtestproject.repositories.LionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LionServiceImplTest {

    @Mock
    private LionRepository lionRepository;

    @Mock
    private HerbivorousService<CowModel> cowService;

    @Mock
    private HerbivorousService<GoatModel> goatService;

    private CarnivorousService<LionModel> lionService;

    @BeforeEach
    void setUp() {
        lionService = new LionServiceImpl(lionRepository, cowService, goatService);
    }

    @Test
    public void feedLion() {
        LionModel lionModel = new LionModel();
        lionModel.setName("testLion");
        lionModel.setEaten(new ArrayList<>());
        CowModel cowModel = new CowModel();
        cowModel.setName("testCow");
        Mockito.when(lionRepository.getLionModelByName("testLion")).thenReturn(Optional.of(lionModel));
        Mockito.when(cowService.getAnimalByName("testCow")).thenReturn(cowModel);
        lionService.feedLion("testLion", "testCow", "cow");
        cowModel.eaten(lionModel);
        lionModel.eat(cowModel);
        Mockito.verify(lionRepository).save(lionModel);
    }

}