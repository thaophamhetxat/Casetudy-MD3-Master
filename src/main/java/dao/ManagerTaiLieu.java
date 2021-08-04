package dao;

import moduls.TaiLieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerTaiLieu {
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

    public static List<TaiLieu> showTaiLieu() throws SQLException, ClassNotFoundException {
        String select = "select * from books";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<TaiLieu> listTaiLieu = new ArrayList<>();

        while (resultSet.next()) {
            int idBook = resultSet.getInt("idBook");
            String nameBook = resultSet.getString("nameBook");
            String descriptionBook = resultSet.getString("descriptionBook");
            String image = resultSet.getString("image");
            String publishingBook = resultSet.getString("publishingBook");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");
            int locationBook = resultSet.getInt("locationBook");
            int amount = resultSet.getInt("amount");

            listTaiLieu.add(new TaiLieu(idBook, nameBook, descriptionBook, image, publishingBook,
                    statusBook, categoryBook, locationBook,amount));
        }
        return listTaiLieu;
    }


    public static void saveTaiLieu(TaiLieu taiLieu) throws SQLException {
        String sqlsave = "insert into books value(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlsave);
        preparedStatement.setInt(1, taiLieu.getIdBook());
        preparedStatement.setString(2, taiLieu.getNameBook());
        preparedStatement.setString(3, taiLieu.getDescriptionBook());
        preparedStatement.setString(4, taiLieu.getImage());
        preparedStatement.setString(5, taiLieu.getPublishingBook());
        preparedStatement.setInt(6, taiLieu.getStatusBook());
        preparedStatement.setInt(7, taiLieu.getCategoryBook());
        preparedStatement.setInt(8, taiLieu.getLocationBook());
        preparedStatement.setInt(9, taiLieu.getAmount());

        preparedStatement.execute();

    }

    public static void editTaiLieu(TaiLieu taiLieu) throws SQLException {
        String sqledit = "update books set nameBook=?,descriptionBook=?,image=?,publishingBook=?," +
                "statusBook=?,categoryBook=?,locationBook=?,amount=? where idBook=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqledit);
        preparedStatement.setString(1, taiLieu.getNameBook());
        preparedStatement.setString(2, taiLieu.getDescriptionBook());
        preparedStatement.setString(3, taiLieu.getImage());
        preparedStatement.setString(4, taiLieu.getPublishingBook());
        preparedStatement.setInt(5, taiLieu.getStatusBook());
        preparedStatement.setInt(6, taiLieu.getCategoryBook());
        preparedStatement.setInt(7, taiLieu.getLocationBook());
        preparedStatement.setInt(8, taiLieu.getAmount());
        preparedStatement.setInt(9, taiLieu.getIdBook());
        preparedStatement.execute();
    }

    public static void deleteTaiLieu(int idBook) throws SQLException {
        String delete = "delete from books where idBook=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, idBook);
        preparedStatement.execute();
    }

    public static ArrayList<TaiLieu> findByName(String findName) throws SQLException {
        ArrayList<TaiLieu> findList = new ArrayList<>();
        String findByName = "select * from books where nameBook like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(findByName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idBook = resultSet.getInt("idBook");
            String nameBook = resultSet.getString("nameBook");
            String descriptionBook = resultSet.getString("descriptionBook");
            String image = resultSet.getString("image");
            String publishingBook = resultSet.getString("publishingBook");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");
            int locationBook = resultSet.getInt("locationBook");
            int amount = resultSet.getInt("amount");

            findList.add(new TaiLieu(idBook, nameBook, descriptionBook, image, publishingBook,
                    statusBook, categoryBook, locationBook,amount));

        }
        return findList;
    }
}
