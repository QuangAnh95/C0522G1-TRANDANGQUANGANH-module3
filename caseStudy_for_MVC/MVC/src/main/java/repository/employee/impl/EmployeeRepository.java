package repository.employee.impl;

import model.Employee;
import repository.customer.BaseRibository;
import repository.employee.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL = "select * from employee where is_delete = 0;";
    private static final String INSERT = "insert into employee(employee_name, employee_birthday, employee_id_card, " +
            "employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, " +
            "division_id) values(?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from employee where employee_id = ? and is_delete = 0;";
    private static final String UPDATE = "update employee set employee_name = ?, employee_birthday = ?, " +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, " +
            "employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? where employee_id = ? and " +
            "is_delete = 0;";
//    private static final String DELETE = "update employee set is_delete = 1 where employee_id = ? and is_delete = 0;";
    private static final String DELETE = "call employee_delete(?);";
    private static final String SEARCH = "select * from employee where is_delete = 0 and employee_name like ? and " +
            "employee_address like ? and employee_phone like ?;";


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRibository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getInt("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");

                Employee employee = new Employee(employeeId,employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId,
                        divisionId);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public boolean create(Employee employee) {
        Connection connection = BaseRibository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());

            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int idDelete) {
        boolean rowDelete = false;
        Connection connection = BaseRibository.getConnectDB();

        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1, idDelete);
            rowDelete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }

}
