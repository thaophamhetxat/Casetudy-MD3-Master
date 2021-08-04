package controller;

import service.TaiLieuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NguoiDungServlet", value = "/nguoidung")
public class NguoiDungServlet extends HttpServlet {
    TaiLieuService taiLieuService = new TaiLieuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "homesp":
                response.sendRedirect("homeND/homeND.jsp");
                break;
            case "buy":
                break;
            case "brorow":
                break;
//            case "create":
//                request.setAttribute("listClass", classService.listClass);
//                requestDispatcher = request.getRequestDispatcher("/createHocVien.jsp");
//                requestDispatcher.forward(request, response);
//                showCreateUser(request, response);
//                break;
//            case "edit":
//                showEdit(request, response);
//                break;
//            case "delete":
//                delete(request, response);
//                break;
//            default:
//                request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
//                requestDispatcher = request.getRequestDispatcher("/homeAdmin/home.jsp");
//                requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                create(request, response);
//                break;
//            case "edit":
//                edit(request, response);
//                break;
//            case "find":
//                find(request, response);
//                break;
        }
    }




}

