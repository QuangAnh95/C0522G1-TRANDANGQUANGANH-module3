package cotroller;

import jdk.nashorn.internal.ir.IfNode;
import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productServlet", value = "/product")
public class productServlet extends HttpServlet {
    private static IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "delete":
                showDelete(request,response);
                break;
            case "update":
                break;
            default:
                showlist(request,response);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void showlist(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.findAll();
        request.setAttribute("product",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
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
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "delete":
                deleteProduct(request,response);
            default:
                showlist(request,response);
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp")
        }
        else {
            iProductService.delete(id);
        }

            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
