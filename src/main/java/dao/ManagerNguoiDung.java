package dao;

import moduls.TaiLieu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerNguoiDung {
    static Connection connection;
    static ArrayList<TaiLieu> listTaiLieuND = new ArrayList<>();

    static {
        try {
            connection = ConnectionMySQL.getConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TaiLieu> select() throws SQLException, ClassNotFoundException {
        String select = "select * from books";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int idBook = resultSet.getInt("idBook");
            String nameBook = resultSet.getString("nameBook");
            String image = resultSet.getString("image");
            String publishingBook = resultSet.getString("publishingBook");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");

            listTaiLieuND.add(new TaiLieu(idBook, nameBook, image, publishingBook,
                    statusBook, categoryBook));
        }
        return listTaiLieuND;
    }
}
