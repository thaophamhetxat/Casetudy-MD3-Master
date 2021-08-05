package dao;

import moduls.Account;

import java.sql.*;

public class UserDAO {
    Connection conn = null;
    Statement st = null;
    PreparedStatement preSt = null;
    public Account getAccount(String email, String password) throws SQLException, ClassNotFoundException {
        if (conn == null)
            conn = ConnectionMySQL.getConnect();
        String sql = "SELECT * FROM accounts WHERE email = ? and pass = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();


        while (result.next()) {
            int id = Integer.parseInt(result.getString("idAccount"));
            Account account = new Account();
            account.setIdAccount(id);
            account.setEmail(email);
            account.setPass(password);
            account.setName(result.getString("name"));
            return account;
        }
        return null;
    }
}
