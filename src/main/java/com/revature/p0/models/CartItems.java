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

public class CartItems {
    private String id;
    private double price;
    private int quantity;
    private String shpc_id;
}
