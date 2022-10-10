package service.customer.impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
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
