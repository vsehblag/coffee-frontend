package com.example.dealfinderapp_v3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Promotion {
    private int id;
    private String title;
    private String establishmentName;
    private String address;
    private String description;
    private String distance;
    private int progress;
    private Drawable imageDrawable;
    private int totalActions;

    public Promotion(int id, String title, String description, String establishmentName, String address, String distance, int progress, Drawable imageDrawable, int totalActions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.establishmentName = establishmentName;
        this.address = address;
        this.distance = distance;
        this.progress = progress;
        this.imageDrawable = imageDrawable;
        this.totalActions = totalActions;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getEstablishmentName() {
        return establishmentName;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return totalActions;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }
}
