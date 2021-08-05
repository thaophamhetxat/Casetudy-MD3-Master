package controller;

import dao.ManagerTaiLieu;
import moduls.TaiLieu;
import service.NguoiDungService;
import service.SelectService;
import service.TaiLieuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "TaiLieuServlet", value = "/tailieu")
public class TaiLieuServlet extends HttpServlet {
    TaiLieuService taiLieuService = new TaiLieuService();
    NguoiDungService nguoiDungService = new NguoiDungService();
    SelectService selectService ;

    {
        try {
            selectService = new SelectService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "homeND":
                response.sendRedirect("homeND/homeND.jsp");
                break;
            case "create":
                request.setAttribute("listStatus", selectService.listStatus);
                request.setAttribute("listCategory", selectService.listCategory);
                request.setAttribute("listLocation", selectService.listLocation);
                requestDispatcher = request.getRequestDispatcher("homeAdmin/createTaiLieu.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "edit":
                request.setAttribute("listStatus", selectService.listStatus);
                request.setAttribute("listCategory", selectService.listCategory);
                request.setAttribute("listLocation", selectService.listLocation);
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
                requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
                requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "find":
                find(request, response);
                break;
        }
    }



    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String nameBook = request.getParameter("nameBook");
        String descriptionBook = request.getParameter("descriptionBook");
        String image = request.getParameter("image");
        String publishingBook = request.getParameter("publishingBook");
        int statusBook = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBook = Integer.parseInt(request.getParameter("categoryBook"));
        int locationBook = Integer.parseInt(request.getParameter("locationBook"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int price = Integer.parseInt(request.getParameter("price"));

        TaiLieu taiLieu = new TaiLieu(idBook, nameBook, descriptionBook,
                image, publishingBook, statusBook,categoryBook,locationBook,amount,price);
        try {
            taiLieuService.save(taiLieu);
            request.setAttribute("listTaiLieuND",nguoiDungService.listTaiLieuND);
            request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idBookEdit = Integer.parseInt(request.getParameter("idBook"));
        String nameBookEdit = request.getParameter("nameBook");
        String descriptionBookEdit = request.getParameter("descriptionBook");
        String imageEdit = request.getParameter("image");
        String publishingBookEdit = request.getParameter("publishingBook");
        int statusBookEdit = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBookEdit = Integer.parseInt(request.getParameter("categoryBook"));
        int locationBookEdit = Integer.parseInt(request.getParameter("locationBook"));
        int amountEdit = Integer.parseInt(request.getParameter("amount"));
        int priceEdit = Integer.parseInt(request.getParameter("price"));

        TaiLieu taiLieuEdit = new TaiLieu(idBookEdit, nameBookEdit, descriptionBookEdit,
                imageEdit, publishingBookEdit, statusBookEdit,categoryBookEdit,locationBookEdit,amountEdit,priceEdit);
        try {
            taiLieuService.edit(taiLieuEdit);
            request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int index = Integer.parseInt(request.getParameter("index"));
        try {
            taiLieuService.delete(index);
            response.sendRedirect("/tailieu");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int indexEdit = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("tailieu", taiLieuService.listTaiLieu.get(indexEdit));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/editTaiLieu.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findName = request.getParameter("findName");
        try {
            request.setAttribute("listTaiLieu", taiLieuService.findByName(findName));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin/homeAD.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
