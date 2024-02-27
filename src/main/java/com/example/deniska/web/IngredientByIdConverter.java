package com.example.deniska.web;


import com.example.deniska.Ingredient;
import com.example.deniska.data.IngredientRepository;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class IngredientByIdConverter implements Converter<String, Ingredient> {
   private final IngredientRepository ingredientRepository;
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
