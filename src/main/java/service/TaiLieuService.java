package service;

import dao.ManagerTaiLieu;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaiLieuService {

    public ArrayList<TaiLieu> listTaiLieu= new ArrayList<>();

    public TaiLieuService() {
        try {
            listTaiLieu = (ArrayList<TaiLieu>) ManagerTaiLieu.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(TaiLieu taiLieu) throws SQLException {
        ManagerTaiLieu.create(taiLieu);
        listTaiLieu.add(taiLieu);
    }

    public void edit(TaiLieu taiLieu, int index) throws SQLException {
        ManagerTaiLieu.edit(taiLieu);
        listTaiLieu.set(index, taiLieu);
    }

    public void delete(int index) throws SQLException {
        ManagerTaiLieu.delete(listTaiLieu.get(index).getNameBook());
        listTaiLieu.remove(index);
    }


    public ArrayList<TaiLieu> findByName(String name) throws SQLException {
        return ManagerTaiLieu.findByName(name);

    }
}
