package dao;

import moduls.GioHang;
import moduls.TaiLieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerNguoiDung {
    static Connection connection;
    static {
        try {
            connection = ConnectionMySQL.getConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<TaiLieu> showND() throws SQLException, ClassNotFoundException {
        String select = "select idBook,nameBook,image,publishingBook,statusBook,categoryBook from books";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<TaiLieu> listTaiLieuND = new ArrayList<>();
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

    public static ArrayList<TaiLieu> findByName(String findName) throws SQLException {
        ArrayList<TaiLieu> findListND = new ArrayList<>();
        String findByName = "select * from books where nameBook like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(findByName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idBook = resultSet.getInt("idBook");
            String nameBook = resultSet.getString("nameBook");
            String image = resultSet.getString("image");
            String publishingBook = resultSet.getString("publishingBook");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");

            findListND.add(new TaiLieu(idBook, nameBook, image, publishingBook,
                    statusBook, categoryBook));
        }
        return findListND;
    }




}
