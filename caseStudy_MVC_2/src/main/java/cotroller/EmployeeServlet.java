package cotroller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import service.division.IDivisionService;
import service.division.impl.DivisionService;
import service.educationDegree.IEducationDegreeService;
import service.educationDegree.impl.EducationDegreeService;
import service.employee.IEmployeeService;
import service.employee.impl.EmployeeService;
import service.position.IPositionService;
import service.position.impl.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IPositionService positionService = new PositionService();
    private IEmployeeService employeeService = new EmployeeService();
    private IEducationDegreeService educationDegreeService = new EducationDegreeService();
    private IDivisionService divisionService = new DivisionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
//                showCreateFrom(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
//                deleteEmployee(request,response);
                break;
            case "find":
//                searchEmployee(request,response);
                break;
            default:
                findAll(request, response);
        }

    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");

        List<Employee>employeeList = employeeService.finAll();
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegree = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationDegree",educationDegree);
        request.setAttribute("divisionList",divisionList);

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
//                Create(request, response);
                break;
            case "edit":
//                updateEmployee(request, response);
                break;
            default:
                findAll(request, response);
        }

    }
}
