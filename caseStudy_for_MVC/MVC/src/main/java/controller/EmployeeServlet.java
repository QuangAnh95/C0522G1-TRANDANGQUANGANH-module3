package controller;

import model.Division;
import model.EducationDegree;
import model.Employee;
import model.Position;
import service.Division.IDivisionService;
import service.Division.impl.DivisionService;
import service.EducationDegree.IEducationDegreeService;
import service.EducationDegree.impl.EducationDegreeService;
import service.Position.IPositionSercive;
import service.Position.impl.PositionSercive;
import service.employee.IEmployeeService;
import service.employee.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();
    private IPositionSercive iPositionSercive = new PositionSercive();
    private IEducationDegreeService iEducationDegreeService = new EducationDegreeService();
    private IDivisionService iDivisionService = new DivisionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
            deleteEmployee(request, response);
                break;
            case "search":
//                searchEmployee(request, response);
                break;
            default:
                findAll(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("employeeId"));
        iEmployeeService.delete(idDelete);
        findAll(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = iPositionSercive.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");

        List<Employee> employeeList = iEmployeeService.findAll();
        List<Position> positionList = iPositionSercive.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = iDivisionService.findAll();

        for (Employee employee : employeeList) {
            String[] arr = employee.getEmployeeBirthday().split("-");
            employee.setEmployeeBirthday(arr[2] + "/" + arr[1] + "/" + arr[0]);
        }

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
                createEmployee(request, response);
                break;
            case "edit":
//                updateEmployee(request, response);
                break;
            default:
                findAll(request, response);
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));

       Employee employee = new Employee(name,dayOfBirth,idCard,salary,phone,email,address,position,educationDegree,division);

        boolean check = iEmployeeService.create(employee);
        String mess = "Add new Employee successfully.";
        if (!check) {
            mess = "Add new Employee failed.";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("check", check);

        showCreateForm(request, response);
    }


}
