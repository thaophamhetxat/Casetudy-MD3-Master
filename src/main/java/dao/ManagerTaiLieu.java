package dao;

import moduls.TaiLieu;

import java.sql.*;
import java.util.ArrayList;

public class ManagerTaiLieu {
    static Connection connection;
    static ArrayList<TaiLieu> listTaiLieu = new ArrayList<>();

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
            String descriptionBook = resultSet.getString("descriptionBook");
            String image = resultSet.getString("image");
            String publishingBook = resultSet.getString("publishingBook");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");
            int locationBook = resultSet.getInt("locationBook");

            listTaiLieu.add(new TaiLieu(idBook, nameBook, descriptionBook, image, publishingBook,
                    statusBook, categoryBook, locationBook));
        }
        return listTaiLieu;
    }

    public static void create(TaiLieu taiLieu) throws SQLException {
        String create = "insert into books value(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1, taiLieu.getIdBook());
        preparedStatement.setString(2, taiLieu.getNameBook());
        preparedStatement.setString(3, taiLieu.getDescriptionBook());
        preparedStatement.setString(4, taiLieu.getImage());
        preparedStatement.setString(5, taiLieu.getPublishingBook());
        preparedStatement.setInt(6, taiLieu.getStatusBook());
        preparedStatement.setInt(7, taiLieu.getCategoryBook());
        preparedStatement.setInt(8, taiLieu.getLocationBook());
        preparedStatement.execute();

    }

    public static void edit(TaiLieu taiLieu) throws SQLException {
        String edit = "update books set nameBook=?,descriptionBook=?,image=?,publishingBook=?," +
                "statusBook=?,categoryBook=?,locationBook=? where idBook=?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1, taiLieu.getNameBook());
        preparedStatement.setString(2, taiLieu.getDescriptionBook());
        preparedStatement.setString(3, taiLieu.getImage());
        preparedStatement.setString(4, taiLieu.getPublishingBook());
        preparedStatement.setInt(5, taiLieu.getStatusBook());
        preparedStatement.setInt(6, taiLieu.getCategoryBook());
        preparedStatement.setInt(7, taiLieu.getLocationBook());
        preparedStatement.setInt(8, taiLieu.getIdBook());
        preparedStatement.execute();
    }

    public static void delete(String nameBook) throws SQLException {
        String delete = "delete from books where nameBook=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setString(1, nameBook);
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

            findList.add(new TaiLieu(idBook, nameBook, descriptionBook, image, publishingBook,
                    statusBook, categoryBook, locationBook));

        }
        return findList;
    }
}
