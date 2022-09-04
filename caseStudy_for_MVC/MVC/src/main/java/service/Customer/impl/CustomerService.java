package service.Customer.impl;

import model.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.Customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    public ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> finAll() {
        return customerRepository.finAll();
    }

    @Override
    public boolean create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public boolean edit(Customer customer) {
        return customerRepository.edit(customer);
    }

    @Override
    public Customer findById(int idFind) {
        return customerRepository.findById(idFind);
    }

    @Override
    public boolean delete(int customerId) {
        return customerRepository.delete(customerId);
    }

    @Override
    public List<Customer> find(String name, String address, String phone) {
        return customerRepository.find(name,address,phone);
    }
}
