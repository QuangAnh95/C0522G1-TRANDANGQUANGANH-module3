package controller;

import model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "clientServlet", value = "/client")
public class clientServlet extends HttpServlet {
    private static List<Client> clients = new ArrayList<>();
    static {
        clients.add(new Client("nguyễn Văn a", "15/04/1950", "Đà Nẵng", "https://toplist.vn/images/800px/tiem-chup-anh-the-thanh-thuy-318816.jpg"));
        clients.add(new Client("nguyễn Văn b", "15/04/1956", "Đà Nẵng", "https://ss-images.saostar.vn/wp700/pc/1651426688710/saostar-m00900fq8s6ho5og.jpg"));
        clients.add(new Client("nguyễn Văn c", "15/04/1990", "Đà Nẵng", "https://top1quangnam.com/wp-content/uploads/2021/08/unnamed-file-1657.jpg"));
        clients.add(new Client("nguyễn Văn d", "15/04/1998", "Đà Nẵng", "https://chupanhthedanang.com/wp-content/uploads/2021/02/chup-anh-the-da-nang.jpg"));
        clients.add(new Client("nguyễn Văn e", "15/04/1999", "Đà Nẵng", "https://media.loveitopcdn.com/54/091609-thumb-15222092411420-ds-770.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display.jsp");
        request.setAttribute("clients",clients);
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
