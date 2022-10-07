package cotroller;

import service.employee.IEmployeeService;
import service.employee.impl.EmployeeService;
import service.position.IPositionService;
import service.position.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IPositionService positionService = new PositionService();
    private IEmployeeService employeeService = new EmployeeService();
    private I
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
