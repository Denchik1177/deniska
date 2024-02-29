package com.example.deniska;

import com.example.deniska.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.deniska.Ingredient.*;

@SpringBootApplication
public class DeniskaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeniskaApplication.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo){
        return args->{
            repo.deleteAll();
            repo.save(new Ingredient("FLTO","Flour Tortilla", Type.WRAP));
            repo.save(new Ingredient("FLTO","Corn Tortilla ", Type.WRAP));
            repo.save(new Ingredient("GRBF","Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN","Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO","Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient("LETC","Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED","Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK","Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA","Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCR","Sour Cream", Type.SAUCE));

        };
    }
}
