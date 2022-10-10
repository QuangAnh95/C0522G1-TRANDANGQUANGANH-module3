package repository.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> finAll();

    boolean create(Employee employee);

    boolean edit(Employee employee);

    Employee findById(int idFind);

    boolean delete (int employeeId);

    List<Employee> find(String nameSearch, String addressSearch, String phoneSearch);
}
