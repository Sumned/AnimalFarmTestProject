package com.backendless.animalfarmtestproject.exceptions;

import com.backendless.animalfarmtestproject.models.CowModel;
import com.backendless.animalfarmtestproject.models.GoatModel;
import com.backendless.animalfarmtestproject.models.Meat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    private String animalType;

    public AnimalException(FeedErrors errors, Meat animal) {
        errorCode = errors.getCode();
        if (animal instanceof CowModel) {
            animalType = "Cow";
        } else if (animal instanceof GoatModel) {
            animalType = "Goat";
        }
        errorMessage = String.format(errors.getMessage(), animalType, animal.getName());
    }

    public AnimalException(FeedErrors errors, String name, String type) {
        errorCode = errors.getCode();
        errorMessage = String.format(errors.getMessage(), type, name);
    }
}
