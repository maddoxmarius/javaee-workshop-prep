package com.dedalus.exception;

import com.dedalus.model.AnimalEntity;
import lombok.Getter;

@Getter
public class AnimalNotAvailableException extends Exception {
    private final AnimalEntity animal;

    public AnimalNotAvailableException(AnimalEntity animal) {
        this.animal = animal;
    }
}
