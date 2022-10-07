package service.employee.impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.EmployeeRepository;
import service.employee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> finAll() {
        return employeeRepository.finAll();
    }

    @Override
    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public boolean edit(Employee employee) {
        return employeeRepository.edit(employee);
    }

    @Override
    public Employee findById(int idFind) {
        return employeeRepository.findById(idFind);
    }

    @Override
    public boolean delete(int employeeId) {
        return employeeRepository.delete(employeeId);
    }

    @Override
    public List<Employee> find(String nameSearch, String addressSearch, String phoneSearch) {
        return employeeRepository.find(nameSearch,addressSearch,phoneSearch);
    }
}
