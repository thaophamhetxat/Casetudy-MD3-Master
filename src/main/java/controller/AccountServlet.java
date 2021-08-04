package controller;

import dao.ManagerAccount;
import dao.UserDAO;
import moduls.Account;
import service.AccountBO;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/account","/"})
public class AccountServlet extends HttpServlet {
    public AccountService accountService = new AccountService();

    private static final long serialVersionUID = 1L;
    private AccountBO accountBO = new AccountBO();
    public AccountServlet() {
        super();
    }

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
            case "logout" -> {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    session.removeAttribute("email");

                    RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
                    dispatcher.forward(req, resp);
                }
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
            case "login" -> {
                String email = req.getParameter("email");
                String password = req.getParameter("pass");
                UserDAO userDao = new UserDAO();
                try {
                    Account account = userDao.getAccount(email, password);
                    String destPage = "account/login.jsp";

                    if (account != null) {
                        HttpSession session = req.getSession();
                        session.setAttribute("acc", account);
                        destPage = "account/test.jsp";
                    } else {
                        String message = "Invalid email/password";
                        req.setAttribute("message", message);
                    }

                    RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
                    dispatcher.forward(req,resp);

                } catch (SQLException | ClassNotFoundException ex) {
                    throw new ServletException(ex);
                }

            }
        }

    }
}
