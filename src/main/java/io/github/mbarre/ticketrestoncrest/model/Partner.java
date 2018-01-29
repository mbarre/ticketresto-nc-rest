package io.github.mbarre.ticketrestoncrest.model;

import java.net.URL;

public class Partner {

    private String name;
    private String category;
    private String foodType;
    private String phone;
    private String address;
    private String city;
    private String district;
    private URL googleMapsUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public URL getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(URL googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }
}
