package com.example.deniska.web;

import com.example.deniska.Ingredient;
import com.example.deniska.Ingredient.Type;
import com.example.deniska.Taco;
import com.example.deniska.TacoOrder;
import com.example.deniska.data.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.example.deniska.Ingredient.Type.*;

/**
 *  Класс обработки
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {
    private final IngredientRepository ingredientRepository;

    public DesignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientToModel(Model model){
    Iterable<Ingredient> ingredients = ingredientRepository.findlAll();
        Type[] types= Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients,type));
        }
    }
    @ModelAttribute(name="tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }
    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    /**
     * Будет использоваться модель, которая будет использоваться ModelAttribute tacoOrder
     */
    @PostMapping
    public String processTaco(Taco taco,
                              @ModelAttribute TacoOrder tacoOrder){
        tacoOrder.addTaco(taco);
        log.info("Обработка Тако:{}", taco);
        return "redirect:/orders/current";
    }
    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {

        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
