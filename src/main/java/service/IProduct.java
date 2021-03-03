package service;

import model.Product;

import java.util.List;

public interface IProduct {
    List<Product> fillAll();
    Product findById(int id);
    Product save(Product product);
    Product update(Product product, int id);
    void delete( int id);
}
