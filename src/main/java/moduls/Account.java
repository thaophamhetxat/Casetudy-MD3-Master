package moduls;

public class Account {
    private int idAccount;
    private String email;
    private String pass;
    private String name;
    private String date;
    private String address;
    private int phone;
    private String img;

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

    public Account(String email, String pass, String name, String date, String address, int phone, String img)
    {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.img = img;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
