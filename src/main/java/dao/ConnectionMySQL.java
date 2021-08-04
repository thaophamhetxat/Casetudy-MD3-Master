package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    public static Connection getConnect() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_md3_qltv";
        String jdbcUsername = "root";
        String jdbcPassword = "aishiteiru123.@";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        if (connection != null) {
            System.out.println("Kết nối thành công");
            return connection;
        }
        return null;
    }
}
