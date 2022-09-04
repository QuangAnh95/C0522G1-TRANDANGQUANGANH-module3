package controller;

import service.employee.IEmployeeService;
import service.employee.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/Employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
//                showCreateFromEmployee(request, response);
                break;
            case "edit":
//                showEditFormEmployee(request, response);
                break;
            case "delete":
//                deleteEmployee(request,response);
                break;
            case "find":
//                searchEmployee(request,response);
                break;
            default:
//                findAllEmployee(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
//                Create(request, response);
                break;
            case "edit":
//                updateCustomer(request, response);
                break;
            default:
//                findAll(request, response);
        }

    }
}
