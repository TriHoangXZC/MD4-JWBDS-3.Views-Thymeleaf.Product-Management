package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();

    int findIndexById(int id);

    Product findProductById(int id);

    void createProduct(Product product);

    void editProductById(int id, Product product);

    void deleteProductById(int id);
}
