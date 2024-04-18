package com.example.osproject.Misc;

import java.io.Serializable;

public class Address implements Serializable {
    private String region;
    private String provinceCity;
    private String barangay;
    private String buildingStreet;

    public Address(String region, String provinceCity, String barangay, String buildingStreet) {
        this.region = region;
        this.provinceCity = provinceCity;
        this.barangay = barangay;
        this.buildingStreet = buildingStreet;
    }

    public String getRegion() {
        return region;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public String getBarangay() {
        return barangay;
    }

    public String getBuildingStreet() {
        return buildingStreet;
    }

    @Override
    public String toString(){
        return region + ", " + provinceCity + ", " + barangay + ", " + buildingStreet;
    }
}
