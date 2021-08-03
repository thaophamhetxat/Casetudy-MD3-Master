package controller;

import moduls.TaiLieu;
import service.TaiLieuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TaiLieuServlet", value = "/tailieu")
public class TaiLieuServlet extends HttpServlet {
    TaiLieuService taiLieuService = new TaiLieuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "homesp":
//                response.sendRedirect("SanPham/showSanPham.jsp");
//                break;
            case "create":
//                request.setAttribute("listClass", classService.listClass);
//                requestDispatcher = request.getRequestDispatcher("/createHocVien.jsp");
//                requestDispatcher.forward(request, response);
                showCreateUser(request,response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
                requestDispatcher = request.getRequestDispatcher("/homeAdmin/home.jsp");
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

        TaiLieu taiLieu = new TaiLieu(idBook, nameBook, descriptionBook,
                image, publishingBook, statusBook,categoryBook,locationBook);
        try {
            taiLieuService.save(taiLieu);
            request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeAdmin/createTaiLieu.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeAdmin/home.jsp");
        requestDispatcher.forward(request, response);
    }


    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBookEdit = Integer.parseInt(request.getParameter("idBook"));
        String nameBookEdit = request.getParameter("nameBook");
        String descriptionBookEdit = request.getParameter("descriptionBook");
        String imageEdit = request.getParameter("image");
        String publishingBookEdit = request.getParameter("publishingBook");
        int statusBookEdit = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBookEdit = Integer.parseInt(request.getParameter("categoryBook"));
        int locationBookEdit = Integer.parseInt(request.getParameter("locationBook"));

        TaiLieu taiLieuEdit = new TaiLieu(idBookEdit, nameBookEdit, descriptionBookEdit,
                imageEdit, publishingBookEdit, statusBookEdit,categoryBookEdit,locationBookEdit);

        int index = Integer.parseInt(request.getParameter("index"));
        try {
            taiLieuService.edit(taiLieuEdit, index);
            request.setAttribute("listTaiLieu", taiLieuService.listTaiLieu);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeAdmin/editTaiLieu.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int index = Integer.parseInt(request.getParameter("index"));
        try {
            taiLieuService.delete(index);
            response.sendRedirect("/tailieu");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int indexEdit = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("tailieu", taiLieuService.listTaiLieu.get(indexEdit));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeAdmin/editTaiLieu.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findName = request.getParameter("findName");
        try {
            request.setAttribute("listTaiLieu", taiLieuService.findByName(findName));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homeAdmin/home.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
