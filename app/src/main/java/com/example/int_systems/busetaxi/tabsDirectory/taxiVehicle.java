package com.example.int_systems.busetaxi.tabsDirectory;

/**
 * Created by Int-Systems on 3/22/2018.
 */
public class taxiVehicle {

    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private String price;
    private int image;

    public taxiVehicle(int id, String title, String shortdesc, double rating, String price, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
