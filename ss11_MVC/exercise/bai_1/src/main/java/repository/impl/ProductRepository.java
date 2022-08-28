package repository.impl;

import javafx.beans.binding.MapExpression;
import model.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
    static Map<Integer,Product>productMap = new HashMap<>();
       static {
           productMap.put(1,new Product(1,"chocopie",20.000,"bánh ngọt","orion"));
           productMap.put(2,new Product(2,"aquvina",10.000,"nước suối","pesi"));
           productMap.put(3,new Product(3,"chucpchus",5.000,"kẹo mút","sascs"));


       }

    @Override
    public List<Product> display() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
           Set<Integer> keyList = productMap.keySet();
        for (Integer key : keyList) {
            if (productMap.get(key).getId()==id){
                return productMap.get(key);
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        int id = product.getId();
        if (id == 0) {
            List<Product> list = new ArrayList<>(productMap.values());
            id = list.get(list.size() - 1).getId() + 1;
            product.setId(id);
            productMap.put(id, product);
        } else {
            productMap.replace(product.getId(), product);
        }

    }
    }

