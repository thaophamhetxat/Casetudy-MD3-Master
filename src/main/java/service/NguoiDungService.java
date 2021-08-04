package service;

import dao.ManagerNguoiDung;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class NguoiDungService {

    public ArrayList<TaiLieu> listTaiLieuND= new ArrayList<>();

    public NguoiDungService() {
        try {
            listTaiLieuND = (ArrayList<TaiLieu>) ManagerNguoiDung.showND();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//    public void save(TaiLieu taiLieu) throws SQLException, ClassNotFoundException {
//        ManagerNguoiDung.create(taiLieu);
//        listTaiLieuND = (ArrayList<TaiLieu>) ManagerTaiLieu.select();
//    }

//    public void edit(TaiLieu taiLieu, int index) throws SQLException, ClassNotFoundException {
//        ManagerNguoiDung.edit(taiLieu);
//        listTaiLieuND = (ArrayList<TaiLieu>) ManagerTaiLieu.select();
//    }

//    public ArrayList<TaiLieu> findByName(String name) throws SQLException {
//        return ManagerNguoiDung.findByName(name);
//
//    }
}
