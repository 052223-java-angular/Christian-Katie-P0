package com.revature.p0.services;

import java.util.List;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.models.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    public List<Product> findAllByCategoryId(String id) {
        return this.productDAO.findAllByCategoryId(id);
    }

    /*------------------------------Helper Method---------------------------*/

    private static ProductService getProductService() {
        return new ProductService(new ProductDAO());
    }
}
