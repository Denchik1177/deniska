package com.example.deniska.data;

import com.example.deniska.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {

}
