package service;

import model.Product;

import java.util.List;

public interface IProduct {
    List<Product> fillAll();
    Product findById(int id);
    Product save(Product product);
    Product update(Product product);
    void delete( int id);
    List<Product>findByName(String name);
}
