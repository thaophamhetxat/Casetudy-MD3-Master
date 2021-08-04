package moduls;

public class NguoiDung {
    int idND;
    String nameND;
    String passND;

    public NguoiDung() {
    }

    public NguoiDung(int idND, String nameND, String passND) {
        this.idND = idND;
        this.nameND = nameND;
        this.passND = passND;
    }

    public int getIdND() {
        return idND;
    }

    public void setIdND(int idND) {
        this.idND = idND;
    }

    public String getNameND() {
        return nameND;
    }

    public void setNameND(String nameND) {
        this.nameND = nameND;
    }

    public String getPassND() {
        return passND;
    }

    public void setPassND(String passND) {
        this.passND = passND;
    }
}
