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

public class OrderItems {
    private String id;
    private int quantity;
    private int price;
    private String orderId;
    private String productId;
}
