package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProduct{

    public static Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(1,new Product(1,"IPhone12",30000,"New Like"));
        productList.put(2,new Product(2,"IPhone11",20000,"New Like"));
        productList.put(3,new Product(3,"IPhoneX",12000,"New Like"));
        productList.put(4,new Product(4,"IPhone12",30000,"New Like"));
        productList.put(5,new Product(5,"IPhone12",30000,"New Like"));
    }
    @Override
    public List<Product> fillAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public Product save(Product product) {
        productList.put(product.getId(),product);
        return product;
    }

    @Override
    public Product update(Product product, int id) {
        productList.replace(id, product);
        return product;
    }

    @Override
    public void delete( int id) {
        productList.remove(id);
    }
}
