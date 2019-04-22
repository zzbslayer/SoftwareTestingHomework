package com.testing.geohash.Domain;


public class StoreEntity {
    private long id;
    private String storename;
    private String image;
    private String description;
    private AddressEntity address;

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(storename);
        sb.append("\t");
        sb.append(address.toString());
        return sb.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
