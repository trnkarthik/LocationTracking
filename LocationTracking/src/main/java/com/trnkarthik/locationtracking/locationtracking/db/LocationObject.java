package com.trnkarthik.locationtracking.locationtracking.db;

/**
 * Created by karthiktangirala on 5/21/14.
 */

public class LocationObject {


    private long id;
    public Double location_lat;
    public Double location_long;
    public String geo_address;
    public Double accuracy;
    public String location_date_time;

    public LocationObject(long id, Double location_lat, Double location_long, String geo_address, Double accuracy, String location_date_time) {
        this.id = id;
        this.location_lat = location_lat;
        this.location_long = location_long;
        this.geo_address = geo_address;
        this.accuracy = accuracy;
        this.location_date_time = location_date_time;
    }

    public LocationObject() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(Double location_lat) {
        this.location_lat = location_lat;
    }

    public Double getLocation_long() {
        return location_long;
    }

    public void setLocation_long(Double location_long) {
        this.location_long = location_long;
    }

    public String getGeo_address() {
        return geo_address;
    }

    public void setGeo_address(String geo_address) {
        this.geo_address = geo_address;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public String getLocation_date_time() {
        return location_date_time;
    }

    public void setLocation_date_time(String location_date_time) {
        this.location_date_time = location_date_time;
    }

    @Override
    public String toString() {
        return "LocationStorage{" +
                "id=" + id +
                ", location_lat=" + location_lat +
                ", location_long=" + location_long +
                ", geo_address='" + geo_address + '\'' +
                ", accuracy=" + accuracy +
                '}';
    }
}
