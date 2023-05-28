package com.revature.p0.services;

import java.util.List;

import com.revature.p0.daos.OrderDAO;
import com.revature.p0.models.Order;
import com.revature.p0.models.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    public List<Order> findAll() {
        return this.orderDAO.findAll();
    }

    public void save(Order obj) {
        this.orderDAO.save(obj);
    }

    /*------------------------------Helper Method---------------------------*/

    private static OrderService getOrderService() {
        return new OrderService(new OrderDAO());
    }
}
