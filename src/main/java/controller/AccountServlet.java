package controller;

import moduls.Account;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/account","/"})
public class AccountServlet extends HttpServlet {
    public AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action){
            case "register" -> {
                req.setAttribute("listRegister", accountService.list);
                requestDispatcher = req.getRequestDispatcher("account/register.jsp");
                requestDispatcher.forward(req, resp);
            }
            default -> {
                req.setAttribute("listAccount", accountService.list);
                requestDispatcher = req.getRequestDispatcher("/account/login.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null){
            action ="";
        }
        switch (action){
            case "register" -> {
                String email = req.getParameter("email");
                String pass = req.getParameter("pass");

                Account account = new Account(email,pass);
                try {
                    accountService.save(account);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/login");
            }
        }

    }
}
