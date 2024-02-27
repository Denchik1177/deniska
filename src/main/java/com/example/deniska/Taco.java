package com.example.deniska;

import lombok.Data;
import lombok.NonNull;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
@Data
public class Taco {
    private long id;
    private Date createdAt = new Date();

    private String name;
    private List<IngredientRef> ingredients;

}
