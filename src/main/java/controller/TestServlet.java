package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action){
            case "test" -> {
                    HttpSession session = req.getSession(false);
                    if (session.getAttribute("acc") != null) {
                        RequestDispatcher dispatcher = req.getRequestDispatcher("account/test.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        String message = "Please login fisrt";
                        req.setAttribute("messagelog", message);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
                        dispatcher.forward(req, resp);
                    }
            }
        }
    }
}

