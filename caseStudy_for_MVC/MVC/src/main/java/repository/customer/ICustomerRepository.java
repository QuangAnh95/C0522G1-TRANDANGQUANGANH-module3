package repository.customer;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> finAll();

    boolean create(Customer customer);

    boolean edit(Customer customer);

    public Customer findById(int idFind);

    boolean delete (int customerId);

    List<Customer> find(String name, String address, String phone);
}
