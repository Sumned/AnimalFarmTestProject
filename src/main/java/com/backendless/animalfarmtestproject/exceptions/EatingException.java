package com.backendless.animalfarmtestproject.exceptions;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.Herbivorous;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EatingException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    private String animalType;

    private String animalName;

    public EatingException(FeedErrors errors, Herbivorous animal) {
        errorCode = errors.getCode();
        if (animal instanceof CowModel) {
            animalType = "Cow";
            animalName = ((CowModel) animal).getName();
        } else if (animal instanceof GoatModel) {
            animalType = "Goat";
            animalName = ((GoatModel) animal).getName();
        }
        errorMessage = String.format(errors.getMessage(), animalType, animalName);
    }
}
