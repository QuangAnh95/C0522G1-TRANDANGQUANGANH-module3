package service.customerType.impl;

import model.customer.CustomerType;
import repository.customerType.ICustomerTypeRepository;
import repository.customerType.impl.CustomerTypeRepository;
import service.customerType.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
