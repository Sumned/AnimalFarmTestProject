package com.backendless.animalfarmtestproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeedErrors {

    ANIMAL_DOESNT_EXIST("00", "%s %s doesn't exist"),
    ANIMAL_ALREADY_EXIST("01", "%s %s already exist"),
    ANIMAL_ALREADY_EATEN("02", "%s %s already eaten");

    private final String code;
    private final String message;
}
