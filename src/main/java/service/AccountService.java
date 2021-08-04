package service;

import dao.ManagerAccount;
import dao.ManagerTaiLieu;
import moduls.Account;
import moduls.TaiLieu;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountService{
    public static ArrayList<Account> list = new ArrayList<>();

    public AccountService (){
        try {
            list = ManagerAccount.select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void save(Account account) throws SQLException, ClassNotFoundException {
        ManagerAccount.insert(account);
        list.add(account);
    }
}
