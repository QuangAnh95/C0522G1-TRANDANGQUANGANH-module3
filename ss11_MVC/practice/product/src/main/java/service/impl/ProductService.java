package service.impl;

import model.Product;
import service.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService implements IProduct {

    private static Map<Integer, Product> products;

    static {
        products.put(1, new Product(1, "chocobie",20.000, "bánh sô cô la", "chocobie"));
        products.put(2, new Product(2, "hảo hảo",10.000,"mì gói", "vinaac"));
        products.put(3, new Product(3, "chucpachuc",1.000, "kẹo mút", "haihai"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }
}
