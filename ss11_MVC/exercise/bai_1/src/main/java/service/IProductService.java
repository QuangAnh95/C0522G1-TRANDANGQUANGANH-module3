package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();

    void remove(int id);

    public Product findById(int id);
    void save(Product product);

}
