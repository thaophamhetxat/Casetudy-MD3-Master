package service;

import dao.UserDAO;
import moduls.Account;

import java.sql.SQLException;

public class AccountBO {
    UserDAO userDAO =new UserDAO();

    public Account getAccount(String email, String password) throws ClassNotFoundException, SQLException {
        Account account = new Account();
        account.setEmail(email);
        account.setPass(password);
        return userDAO.getAccount(email, password);
    }
}
