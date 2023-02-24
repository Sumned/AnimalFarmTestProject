package com.backendless.animalfarmtestproject.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeedErrors {

    ANIMAL_DOESNT_EXIST("00", "%s %s doesn't exist"),
    ANIMAL_ALREADY_EATEN("01", "%s %s already eaten");

    private final String code;
    private final String message;
}
