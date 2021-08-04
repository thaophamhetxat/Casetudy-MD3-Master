package dao;

import moduls.CategoryTL;
import moduls.LocationTL;
import moduls.StatussTL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectTL {
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

    public static ArrayList<StatussTL> selectStatus() throws SQLException, ClassNotFoundException {
        String select = "select * from statuss";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<StatussTL> listStatus = new ArrayList<>();
        while (resultSet.next()) {
            int idStatus = Integer.parseInt(resultSet.getString("idStatus"));
            String nameStatus = resultSet.getString("nameStatus");
            listStatus.add(new StatussTL(idStatus, nameStatus));
        }
        return listStatus;
    }

    public static ArrayList<CategoryTL> selectCategory() throws SQLException, ClassNotFoundException {
        String select = "select * from Category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<CategoryTL> listCategory = new ArrayList<>();
        while (resultSet.next()) {
            int idCategory = Integer.parseInt(resultSet.getString("idCategory"));
            String nameCategory = resultSet.getString("nameCategory");
            listCategory.add(new CategoryTL(idCategory, nameCategory));
        }
        return listCategory;
    }


    public static ArrayList<LocationTL> selectLocation() throws SQLException, ClassNotFoundException {
        String select = "select * from location";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<LocationTL> listLocation = new ArrayList<>();
        while (resultSet.next()) {
            int idLocation = Integer.parseInt(resultSet.getString("idLocation"));
            String nameLocation = resultSet.getString("nameLocation");
            listLocation.add(new LocationTL(idLocation, nameLocation));
        }
        return listLocation;
    }

}
