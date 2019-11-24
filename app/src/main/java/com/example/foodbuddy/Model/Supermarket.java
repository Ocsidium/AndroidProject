package com.example.foodbuddy.Model;

public class Supermarket {

    private String name;
    private double rating;
    private double lat;
    private double lon;

    public Supermarket(String name, double rating, double lat, double lon) {
        this.name = name;
        this.rating = rating;
        this.lat = lat;
        this.lon = lon;
    }

    public Supermarket() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
