import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "productServlet", value = "/check")
public class productServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("ListPrice"));
        int n2 = Integer.parseInt(request.getParameter("DiscountPercent"));
        int n3 = (int) (n1 * n2* 0.01);
        int n4 = n1-n3;

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        request.setAttribute("ListPrice", n1);
        request.setAttribute("DiscountPercent", n2);
        request.setAttribute("DiscountAmount", n3);
        request.setAttribute("DiscountPrice", n4);
        requestDispatcher.forward(request, response);

    }
}
