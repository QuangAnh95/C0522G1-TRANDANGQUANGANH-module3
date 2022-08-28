package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
   List<Product> display();

   void remove(int id);

   public Product findById(int id);
   void save(Product product);

}
