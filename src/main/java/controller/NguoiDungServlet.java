package controller;
import moduls.GioHang;
import service.GioHangService;
import service.NguoiDungService;


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
    GioHangService gioHangService = new GioHangService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            nguoiDungService.getlistND();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrowND":
                response.sendRedirect("homeND/homeBorrowND.jsp");
                break;
            case "buyND":
                response.sendRedirect("homeND/homeBuyND.jsp");
                break;
            case "buy":
                showBuy(request,response);
                break;
            case "borrow":
                showBorrow(request,response);
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
                buy(request,response);
                break;
            case "borrow":
                borrow(request,response);
                break;
            case "find":
                find(request, response);
                break;
        }
    }

    protected void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBookBuy = Integer.parseInt(request.getParameter("idBook"));
        String nameNDBuy = request.getParameter("nameND");
        String nameBookBuy = request.getParameter("nameBook");
        String imageBuy = request.getParameter("image");
        int statusBookBuy = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBook = Integer.parseInt(request.getParameter("categoryBook"));
        int amountBuy = Integer.parseInt(request.getParameter("amount"));
        String dateHDBuy = request.getParameter("dateHD");
        int idHDBuy = Integer.parseInt(request.getParameter("idHD"));
        double priceBuy = Integer.parseInt(request.getParameter("price"));

        GioHang gioHang = new GioHang(idBookBuy,nameNDBuy,nameBookBuy,imageBuy,statusBookBuy,categoryBook
        ,amountBuy,dateHDBuy,idHDBuy,priceBuy);
        try {
            gioHangService.buy(gioHang);
            request.setAttribute("listGioHang", gioHangService.listGioHang);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeND/homeND.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void borrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String nameND = request.getParameter("nameND");
        String nameBook = request.getParameter("nameBook");
        String image = request.getParameter("image");
        int statusBook = Integer.parseInt(request.getParameter("statusBook"));
        int categoryBook = Integer.parseInt(request.getParameter("categoryBook"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String dateHD = request.getParameter("dateHD");
        int idHD = Integer.parseInt(request.getParameter("idHD"));
        GioHang gioHangBorrow = new GioHang(idBook,nameND,nameBook,image,statusBook,categoryBook,amount,dateHD,idHD);

        try {
            gioHangService.borrow(gioHangBorrow);
            request.setAttribute("listGioHang", gioHangService.listGioHang);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeND/homeND.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void showBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int indexEdit = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("nguoidung", nguoiDungService.listTaiLieuND.get(indexEdit));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeND/homeBorrowND.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void showBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int indexEdit = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("nguoidung", nguoiDungService.listTaiLieuND.get(indexEdit));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeND/homeBuyND.jsp");
        requestDispatcher.forward(request, response);
    }

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

