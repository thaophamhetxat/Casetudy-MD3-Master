package dao;

import moduls.GioHang;
import moduls.TaiLieu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerGioHang {
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

    public static List<GioHang> showGioHang() throws SQLException, ClassNotFoundException {
        String select = "select books.idBook,nameBook,image,publishingBook,CategoryBook,statusBook,amount,dateHD,nameND\n" +
                "from books\n" +
                "join hoadonchitiet on hoadonchitiet.idBook=books.idBook\n" +
                "join nguoidung on hoadonchitiet.idND=nguoidung.idND\n" +
                "join hoadon on hoadon.idND=nguoidung.idND";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<GioHang> listGioHang = new ArrayList<>();

        while (resultSet.next()) {
            int idBook = resultSet.getInt("idBook");
            String nameND = resultSet.getString("nameND");
            String nameBook = resultSet.getString("nameBook");
            String image = resultSet.getString("image");
            int statusBook = resultSet.getInt("statusBook");
            int categoryBook = resultSet.getInt("categoryBook");
            int amount = resultSet.getInt("amount");
            String dateHD = resultSet.getString("dateHD");
            int idHD = resultSet.getInt("idHD");

            listGioHang.add(new GioHang(idBook,nameND,nameBook,image,statusBook,amount
                    ,categoryBook,dateHD,idHD));
        }
        return listGioHang;
    }

    public static void borrow(GioHang gioHang) throws SQLException {
        String sqledit = "update books set nameBook=?,image=?,statusBook=?,categoryBook=?," +
                "amount=?,dateHD=?,nameND=?,idHD=? where idBook=? " +
                "join hoadonchitiet on hoadonchitiet.idBook=books.idBook\n" +
                "join nguoidung on hoadonchitiet.idND=nguoidung.idND\n" +
                "join hoadon on hoadon.idND=nguoidung.idND";
        PreparedStatement preparedStatement = connection.prepareStatement(sqledit);
        preparedStatement.setString(1, gioHang.getNameBook());
        preparedStatement.setString(2, gioHang.getImage());
        preparedStatement.setInt(3, gioHang.getStatusBook());
        preparedStatement.setInt(4, gioHang.getCategoryBook());
        preparedStatement.setInt(5, gioHang.getAmount());
        preparedStatement.setString(6, gioHang.getDateHD());
        preparedStatement.setString(7, gioHang.getNameND());
        preparedStatement.setInt(8, gioHang.getIdHD());
        preparedStatement.setInt(9, gioHang.getIdBook());
        preparedStatement.execute();
    }

    public static void buy(GioHang gioHang) throws SQLException {
        String splbuy = "update books set nameBook=?,image=?,statusBook=?,categoryBook=?," +
        "amount=?,dateHD=?,nameND=?,idHD=?,price=? where idBook=? " +
                "join hoadonchitiet on hoadonchitiet.idBook=books.idBook\n" +
                "join nguoidung on hoadonchitiet.idND=nguoidung.idND\n" +
                "join hoadon on hoadon.idND=nguoidung.idND";
        PreparedStatement preparedStatement = connection.prepareStatement(splbuy);
        preparedStatement.setString(1, gioHang.getNameBook());
        preparedStatement.setString(2, gioHang.getImage());
        preparedStatement.setInt(3, gioHang.getStatusBook());
        preparedStatement.setInt(4, gioHang.getCategoryBook());
        preparedStatement.setInt(5, gioHang.getAmount());
        preparedStatement.setString(6, gioHang.getDateHD());
        preparedStatement.setString(7, gioHang.getNameND());
        preparedStatement.setInt(8, gioHang.getIdHD());
        preparedStatement.setDouble(9, gioHang.getPrice());
        preparedStatement.setInt(10, gioHang.getIdBook());
        preparedStatement.execute();
    }

}
