package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);

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
        return iProductRepository.findById(id);
    }
}
