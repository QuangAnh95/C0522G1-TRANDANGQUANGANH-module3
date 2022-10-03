package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productList = new LinkedHashMap<>();

    static {
        productList.put(1, new Product(1, "OMO", 150000, "bột giặc", "unilevel"));
        productList.put(2, new Product(2, "SUNSILK", 10000, "dầu gội", "unilevel"));
        productList.put(3, new Product(3, "P/S", 450000, "kem đánh răng", "unilevel"));
        productList.put(4, new Product(4, "COMFO", 15500, "nước xã vải", "unilevel"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public void delete(int id) {
        productList.remove(id);

    }

    @Override
    public List<Product> search(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }
}
