package com.example.experthp.ajayelectro.Model;

/**
 * Created by expert HP on 21-Feb-2016.
 */

public class GridProductIMG {
    private int icon;
    private String title;
    private String price;

    public GridProductIMG(int icon, String title, String price) {
        this.icon = icon;
        this.title = title;
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
