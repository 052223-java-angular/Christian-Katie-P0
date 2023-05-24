package com.revature.p0.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Products {
    private String id;
    private String name;
    private double price;
    private String category;
    private String shopping_cart_id;
}
