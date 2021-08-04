package dao;

import com.mysql.cj.protocol.x.Notice;
import moduls.Account;
import moduls.TaiLieu;

import java.sql.*;
import java.util.ArrayList;

public class ManagerAccount {
    static Connection connection;
    static {
        try {
            connection = ConnectionMySQL.getConnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Account> accounts = new ArrayList<>();

    public static ArrayList<Account> select () throws SQLException {
        String select = "select * from accounts";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("idAccount"));
            String emails = resultSet.getString("email");
            String pass = resultSet.getString("pass");

            accounts.add(new Account(id,emails,pass));
        }
        return accounts;
    }
    public static void insert (Account account) throws SQLException {
        String insert = "insert into accounts(email,pass) values(?,?)";
        PreparedStatement prep = connection.prepareStatement(insert);
        prep.setString(1, account.getEmail());
        prep.setString(2, account.getPass());
        prep.execute();
    }

}
