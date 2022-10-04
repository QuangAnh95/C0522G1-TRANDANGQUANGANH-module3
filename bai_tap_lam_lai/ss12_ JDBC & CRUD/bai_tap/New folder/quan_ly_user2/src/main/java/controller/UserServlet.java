package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/user"})
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action"); // null
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showformcreate":
                showFormCreate(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "deleteUser":
                submitDelete(request, response);
                break;
            case "showEdit":
                showEdit(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        if (user == null){
            requestDispatcher= request.getRequestDispatcher("error.jsp");
        }
        else {
            request.setAttribute("user",user);
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

    private void submitDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        try {
            response.sendRedirect("/user?show=Xoa%20Thanh%20Cong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        User user =userService.findById(id);
        if (user==null){
            requestDispatcher=request.getRequestDispatcher("/error.jsp");
        }
        else {
            request.setAttribute("user",user);
            requestDispatcher = request.getRequestDispatcher("/delete.jsp");
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country= request.getParameter("country");
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        userService.updateUser(user);
        try {
            response.sendRedirect("/user?show=Thay%20Đổi%20Thành%20Công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        String show = request.getParameter("show");
        request.setAttribute("show", show);
        List<User> list = userService.list();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        userService.save(user);
        try {
            response.sendRedirect("/user?show=Thêm%20Mới%20Thành%20Công");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
