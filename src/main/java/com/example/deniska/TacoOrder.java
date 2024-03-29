package com.example.deniska;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс заказов, осуществление платежа
 */
@Data
public class TacoOrder {
    private long id;
    private Date placedAt;
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;
    @NotBlank(message = "Delivery city is required")
    private String deliveryCity;
    @NotBlank(message = "Delivery state is required")
    private String deliveryState;
    @NotBlank(message = "Delivery Zip is required")
    private String deliveryZip;
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])(\\/)([2-9][0-9]) $",
            message="Must be formatted MM/YY")
    private String ccExp;
    @Digits(integer = 3, fraction = 0, message ="Invalid CVV")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

}
