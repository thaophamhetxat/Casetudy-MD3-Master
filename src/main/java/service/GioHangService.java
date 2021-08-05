package service;

import dao.ManagerGioHang;
import dao.ManagerNguoiDung;
import moduls.GioHang;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class GioHangService {

    public ArrayList<GioHang> listGioHang= new ArrayList<>();

    public GioHangService() {
        try {
            listGioHang = (ArrayList<GioHang>) ManagerGioHang.showGioHang();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void buy(GioHang gioHang) throws SQLException, ClassNotFoundException {
        ManagerGioHang.buy(gioHang);
        listGioHang = (ArrayList<GioHang>) ManagerGioHang.showGioHang();
    }

    public void borrow(GioHang gioHang) throws SQLException, ClassNotFoundException {
        ManagerGioHang.borrow(gioHang);
        listGioHang=(ArrayList<GioHang>)ManagerGioHang.showGioHang();
    }

}
