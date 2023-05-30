package com.revature.p0.services;

import java.util.List;

import com.revature.p0.daos.OrderDAO;
import com.revature.p0.models.Order;
import com.revature.p0.models.OrderItems;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    // public List<Order> findAllByUserId(String id) {
    // return this.orderDAO.findAllByUserId(id);
    // }

    public List<Order> findAllByUsername(String username) {
        return this.orderDAO.findAllByUsername(username);
    }

    public List<OrderItems> findAllByOrderItemId(String id) {
        return this.orderDAO.findAllByOrderItemId(id);
    }

    public String findProductNameById(String id) {
        return this.orderDAO.findProductNameById(id);
    }

    public void save(Order obj) {
        this.orderDAO.save(obj);
    }

    /*------------------------------Helper Method---------------------------*/

    public static OrderService getOrderService() {
        return new OrderService(new OrderDAO());
    }
}
