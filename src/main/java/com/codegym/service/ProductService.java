package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone 13 Pro Max", 1500, "New", "Apple"));
        products.add(new Product(2, "Iphone 13 Pro", 1300, "New", "Apple"));
        products.add(new Product(3, "Iphone 13", 1100, "New", "Apple"));
        products.add(new Product(4, "S22 Ultra", 1500, "New", "Samsung"));
        products.add(new Product(5, "S22", 1300, "New", "Samsung"));
    }
    @Override
    public List<Product> displayAll() {
        return products;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Product findProductById(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            return products.get(index);
        }
        return null;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void editProductById(int id, Product product) {
        int index = findIndexById(id);
        products.set(index, product);
    }

    @Override
    public void deleteProductById(int id) {
        int index = findIndexById(id);
        products.remove(index);
    }
}
