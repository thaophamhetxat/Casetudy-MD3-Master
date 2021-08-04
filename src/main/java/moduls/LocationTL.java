package moduls;

public class LocationTL {
    int idLocation;
    String nameLocation;

    public LocationTL() {
    }

    public LocationTL(int idLocation, String nameLocation) {
        this.idLocation = idLocation;
        this.nameLocation = nameLocation;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }
}
