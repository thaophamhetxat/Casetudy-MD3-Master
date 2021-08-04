package service;

import dao.ManagerAccount;
import moduls.Account;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountService{
    public static ArrayList<Account> list = new ArrayList<>();

    public AccountService (){

    }
    public void save(Account account) throws SQLException, ClassNotFoundException {
        ManagerAccount.insert(account);
        list.add(account);
    }
}
