package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "showedit":
                showedit(request,response);
                break;
            case "delete":
                showDelete(request,response);
            default:
                showList(request,response);
        }

    }

    private void showedit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        // nếu có -> trả về person / nếu không trả về null
        Product product = iProductService.findById(id);

        if(product == null){
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        }else {
            request.setAttribute("pro",product);
            requestDispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product= iProductService.findById(id);
        request.setAttribute("pro",product);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        String name = request.getParameter("name");
        product.setName(name);
        iProductService.save(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showList.jsp");
        request.setAttribute("list",iProductService.display());
        try {
            requestDispatcher.forward(request,response);
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
        if (action ==null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                delete(request,response);
            default:
                showList(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.remove(id);
     showList(request,response);
    }

}
