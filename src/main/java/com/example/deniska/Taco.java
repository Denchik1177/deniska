package com.example.deniska;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
@Table
@Data
public class Taco {
    @Id
    private long id;
    private Date createdAt = new Date();

    private String name;
    private List<IngredientRef> ingredients;

}
