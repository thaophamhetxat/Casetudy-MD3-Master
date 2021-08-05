package service;

import dao.ManagerNguoiDung;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class NguoiDungService {

    public ArrayList<TaiLieu> listTaiLieuND = new ArrayList<>();

    public NguoiDungService() {
        try {
            getlistND();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getlistND() throws SQLException, ClassNotFoundException {
        listTaiLieuND = (ArrayList<TaiLieu>) ManagerNguoiDung.showND();

    }
//    public void buy(TaiLieu taiLieu) throws SQLException, ClassNotFoundException {
//        ManagerNguoiDung.create(taiLieu);
//        listTaiLieuND = (ArrayList<TaiLieu>) ManagerTaiLieu.select();
//    }

//    public void borrow(TaiLieu taiLieu) throws SQLException, ClassNotFoundException {
//        ManagerNguoiDung.borrow(taiLieu);
//        listTaiLieuND = (ArrayList<TaiLieu>) ManagerNguoiDung.showND();
//    }

    public ArrayList<TaiLieu> findByName(String name) throws SQLException {
        return ManagerNguoiDung.findByName(name);

    }

}
