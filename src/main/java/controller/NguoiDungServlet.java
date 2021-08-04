package controller;

import moduls.TaiLieu;
import service.NguoiDungService;
import service.TaiLieuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NguoiDungServlet", value = "/nguoidung")
public class NguoiDungServlet extends HttpServlet {
    NguoiDungService nguoiDungService = new NguoiDungService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "buy":
                response.sendRedirect("homeND/buyND.jsp");
                break;
            case "borrow":
                response.sendRedirect("homeND/borrowND.jsp");
                break;
            default:
                request.setAttribute("listTaiLieuND", nguoiDungService.listTaiLieuND);
                requestDispatcher = request.getRequestDispatcher("homeND/homeND.jsp");
                requestDispatcher.forward(request, response);
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
            case "buy":
                break;
            case "borrow":
                break;
            case "find":
                find(request, response);
                break;
        }
    }

//    protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int idBook = Integer.parseInt(request.getParameter("idBook"));
//        String nameBook = request.getParameter("nameBook");
//        String image = request.getParameter("image");
//        String publishingBook = request.getParameter("publishingBook");
//        int statusBook = Integer.parseInt(request.getParameter("statusBook"));
//        int categoryBook = Integer.parseInt(request.getParameter("categoryBook"));
//
//
//        TaiLieu taiLieu = new TaiLieu(idBook, nameBook, image,
//                publishingBook,statusBook,categoryBook);
//        try {
//            nguoiDungService.buy(taiLieu);
//            request.setAttribute("listTaiLieu", nguoiDungService.listTaiLieuND);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
//            requestDispatcher.forward(request, response);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findName = request.getParameter("findName");
        try {
            request.setAttribute("listTaiLieuND", nguoiDungService.findByName(findName));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeND/homeND.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

