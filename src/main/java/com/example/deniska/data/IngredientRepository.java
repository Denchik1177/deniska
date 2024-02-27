package com.example.deniska.data;

import com.example.deniska.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findlAll();
    Optional<Ingredient> findById(String Id);
    Ingredient save(Ingredient ingredient);

}
