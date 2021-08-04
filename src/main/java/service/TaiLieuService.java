package service;

import dao.ManagerTaiLieu;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaiLieuService {

    public ArrayList<TaiLieu> listTaiLieu= new ArrayList<>();

    public TaiLieuService() {
        try {
            listTaiLieu = (ArrayList<TaiLieu>) ManagerTaiLieu.showTaiLieu();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void save(TaiLieu taiLieu) throws SQLException, ClassNotFoundException {
        ManagerTaiLieu.saveTaiLieu(taiLieu);
        listTaiLieu= (ArrayList<TaiLieu>) ManagerTaiLieu.showTaiLieu();
    }

    public void edit(TaiLieu taiLieu) throws SQLException, ClassNotFoundException {
        ManagerTaiLieu.editTaiLieu(taiLieu);
        listTaiLieu=(ArrayList<TaiLieu>)ManagerTaiLieu.showTaiLieu();
    }

    public void delete(int index) throws SQLException, ClassNotFoundException {
        ManagerTaiLieu.deleteTaiLieu(listTaiLieu.get(index).getIdBook());
        listTaiLieu= (ArrayList<TaiLieu>) ManagerTaiLieu.showTaiLieu();
    }

    public ArrayList<TaiLieu> findByName(String name) throws SQLException {
        return ManagerTaiLieu.findByName(name);

    }
}
