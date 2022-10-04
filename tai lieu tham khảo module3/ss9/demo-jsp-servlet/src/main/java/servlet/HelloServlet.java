package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello", "/xin-chao"})
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost chay thi ta thực hiện gửi request bằng method post
        // lấy dữ liệu
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        int sum = n1 + n2;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Method do post: ket qua la:" + sum + " <h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doGet chay thi ta thực hiện gửi request bằng method get

        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        int sum = n1 + n2;
        // cách 1: không được phép dùng
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<h1>Method do get: ket qua la:"+sum+" <h1>");
        //cách 2:
        // chuyển sang 1 trang mới
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("ketQua", sum);
        requestDispatcher.forward(request, response);

    }
}
