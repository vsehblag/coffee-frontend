package com.example.dealfinderapp_v3.ui.establishment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Establishment {
    private int id;
    private Drawable poster;
    private String name;
    private double latitude;
    private double longitude;
    private String description;
    private String workingHours;
    private String address;
    private String distance;
    // Другие поля, такие как изображение, время работы и т. д.


    public Establishment() {
        // Пустой конструктор
    }
    public Establishment(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Drawable getPoster() {
        return poster;
    }

    public void setPoster(Drawable poster) {
        this.poster = poster;
    }
}

