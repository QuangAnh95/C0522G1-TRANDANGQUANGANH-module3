package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add(Product product);

    void delete(int id);

    List<Product> search (String name);

    void update(int id,Product product);

    Product findById(int id);


}
