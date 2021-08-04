package moduls;

public class Account {
    private int idAccount;
    private String email;
    private String pass;

    public Account(int idAccount, String email, String pass) {
        this.idAccount = idAccount;
        this.email = email;
        this.pass = pass;
    }
    public Account(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public Account() {

    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
