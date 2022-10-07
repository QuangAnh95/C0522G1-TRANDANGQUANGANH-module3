package service.employee;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> finAll();

    boolean create(Employee employee);

    boolean edit(Employee employee);

    public Employee findById(int idFind);

    boolean delete (int employeeId);

    List<Employee> find(String nameSearch, String addressSearch, String phoneSearch);
}
