package repository.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> finAll();

    boolean create(Customer customer);

    boolean edit(Customer customer);

    Customer findById(int idFind);

    boolean delete (int customerId);

    List<Customer> find(String name, String address, String phone);

}
