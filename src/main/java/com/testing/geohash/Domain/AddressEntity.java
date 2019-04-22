package com.testing.geohash.Domain;

public class AddressEntity{
    private long id;
    private String address;
    private double longitude;
    private double latitude;
    private String geohash;


    public AddressEntity(){};

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(address);
        sb.append("\t(");
        sb.append(getLongitude());
        sb.append(", ");
        sb.append(getLatitude());
        sb.append(")");
        return sb.toString();
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }
}
