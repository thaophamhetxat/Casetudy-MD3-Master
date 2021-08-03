package moduls;

public class TaiLieu {
    int idBook;// id
    String nameBook;//tên
    String descriptionBook;//mô tả
    String image;//ảnh
    String publishingBook;//nhà xuất bản
    int statusBook ;//trạng thái
    int categoryBook ;//thể loại
    int locationBook ;//vị trí

    public TaiLieu() {
    }

    public TaiLieu(int idBook, String nameBook, String descriptionBook, String image, String publishingBook,
                   int statusBook, int categoryBook, int locationBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.descriptionBook = descriptionBook;
        this.image = image;
        this.publishingBook = publishingBook;
        this.statusBook = statusBook;
        this.categoryBook = categoryBook;
        this.locationBook = locationBook;
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

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
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

    public int getLocationBook() {
        return locationBook;
    }

    public void setLocationBook(int locationBook) {
        this.locationBook = locationBook;
    }
}
