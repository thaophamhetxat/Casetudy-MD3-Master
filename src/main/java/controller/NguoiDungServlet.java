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
            case "homesp":
                response.sendRedirect("homeND/homeND.jsp");
                break;
            case "buy":
                break;
            case "borrow":
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

        }
    }

    protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String nameBook = request.getParameter("nameBook");
        String image = request.getParameter("image");
        String publishingBook = request.getParameter("publishingBook");
        int statusBook = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBook = Integer.parseInt(request.getParameter("categoryBook"));


        TaiLieu taiLieu = new TaiLieu(idBook, nameBook, image,
                publishingBook,statusBook,categoryBook);
        try {
            nguoiDungService.buy(taiLieu);
            request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

