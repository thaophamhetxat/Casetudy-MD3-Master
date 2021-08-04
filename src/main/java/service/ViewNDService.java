package service;

import dao.ManagerTaiLieu;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViewNDService {

    public ArrayList<TaiLieu> listViewND= new ArrayList<>();

    public ViewNDService() {
        try {
            listViewND = (ArrayList<TaiLieu>) ManagerTaiLieu.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(TaiLieu taiLieu) throws SQLException {
        ManagerTaiLieu.create(taiLieu);
        listViewND.add(taiLieu);
    }

    public void edit(TaiLieu taiLieu, int index) throws SQLException {
        ManagerTaiLieu.edit(taiLieu);
        listViewND.set(index, taiLieu);
    }

    public ArrayList<TaiLieu> findByName(String name) throws SQLException {
        return ManagerTaiLieu.findByName(name);

    }
}
