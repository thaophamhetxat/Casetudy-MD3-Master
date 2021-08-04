package service;

import dao.SelectTL;
import moduls.CategoryTL;
import moduls.LocationTL;
import moduls.StatussTL;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectService {

    public static ArrayList<StatussTL> listStatus = new ArrayList<>();
    public static ArrayList<CategoryTL> listCategory = new ArrayList<>();
    public static ArrayList<LocationTL> listLocation = new ArrayList<>();

    public SelectService() throws SQLException, ClassNotFoundException {
        listStatus = SelectTL.selectStatus();
        listCategory = SelectTL.selectCategory();
        listLocation = SelectTL.selectLocation();

    }


}
