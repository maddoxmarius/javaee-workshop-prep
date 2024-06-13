package com.dedalus.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.dedalus.model.AnimalType;

public class AnimalTypeValidator implements ConstraintValidator<ValidAnimalType, AnimalType> {

    private List<String> validAnimalTypes;

    @Override
    public void initialize(ValidAnimalType constraintAnnotation) {
        validAnimalTypes = Arrays.stream(AnimalType.values())
                .map(AnimalType::getType)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(AnimalType animalType, ConstraintValidatorContext context) {
        return animalType != null && validAnimalTypes.contains(animalType.getType());
    }
}
