package moduls;

public class GioHang {
    String nameND;
    int idBook;// id
    String nameBook;//tên
    String image;//ảnh
    String publishingBook;//nhà xuất bản
    int statusBook ;//trạng thái
    int categoryBook ;//thể loại
    int amount;
    double price;
    String dateHD;
    String ngayTra;
    int idHD;

    public GioHang(){}


    public GioHang(String nameND, int idBook, String nameBook, String image, String publishingBook, int statusBook,
                   int categoryBook, int amount, double price, String dateHD, String ngayTra, int idHD) {
        this.nameND = nameND;
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.image = image;
        this.publishingBook = publishingBook;
        this.statusBook = statusBook;
        this.categoryBook = categoryBook;
        this.amount = amount;
        this.price = price;
        this.dateHD = dateHD;
        this.ngayTra = ngayTra;
        this.idHD = idHD;
    }

    public GioHang(int idBook, String nameND, String nameBook, String image,
                   int statusBook, int categoryBook, int amount, String dateHD, int idHD) {
        this.idBook = idBook;
        this.idHD = idHD;
        this.nameND = nameND;
        this.nameBook = nameBook;
        this.image = image;
        this.statusBook = statusBook;
        this.categoryBook = categoryBook;
        this.amount = amount;
        this.dateHD = dateHD;
    }

    public GioHang(int idBook, String nameND, String nameBook, String image,
                   int statusBook, int categoryBook, int amount, String dateHD, int idHD,double price) {
        this.idBook = idBook;
        this.idHD = idHD;
        this.nameND = nameND;
        this.nameBook = nameBook;
        this.image = image;
        this.statusBook = statusBook;
        this.categoryBook = categoryBook;
        this.amount = amount;
        this.dateHD = dateHD;
        this.price= price;
    }

    public String getNameND() {
        return nameND;
    }

    public void setNameND(String nameND) {
        this.nameND = nameND;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishingBook() {
        return publishingBook;
    }

    public void setPublishingBook(String publishingBook) {
        this.publishingBook = publishingBook;
    }

    public int getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(int statusBook) {
        this.statusBook = statusBook;
    }

    public int getCategoryBook() {
        return categoryBook;
    }

    public void setCategoryBook(int categoryBook) {
        this.categoryBook = categoryBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateHD() {
        return dateHD;
    }

    public void setDateHD(String dateHD) {
        this.dateHD = dateHD;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }
}
