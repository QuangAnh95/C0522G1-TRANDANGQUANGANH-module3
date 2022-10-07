package cotroller;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import service.facility.IFacilityService;
import service.facility.impl.FacilityService;
import service.facilityType.IFacilityTypeService;
import service.facilityType.impl.FacilityTypeService;
import service.rentType.IRentTypeService;
import service.rentType.impl.RentTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();
    private IRentTypeService rentTypeService = new RentTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                deleteFacility(request, response);
//                break;
//            case "search":
//                searchFacility(request, response);
//                break;
            default:
                findAll(request, response);
        }


    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/facility/list.jsp");
        List<Facility> facilityList = facilityService.findAll();
        List<FacilityType> facilityTypes = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();

        request.setAttribute("facilityList ", facilityList);
        request.setAttribute("facilityTypes", facilityTypes);
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            dispatcher.forward(request, response);
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
//                createFacility(request, response);
                break;
            case "edit":
//                updateFacility(request, response);
                break;
            default:
                break;
        }
    }

}


