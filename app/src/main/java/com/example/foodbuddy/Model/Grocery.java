package com.example.foodbuddy.Model;

public class Grocery {

    private int id;
    private String name;
    private String quantity;
    private String dateItemAdded;

    public Grocery() {

    }

    public Grocery(int id, String name, String quantity, String dateItemAdded) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dateItemAdded = dateItemAdded;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDateItemAdded() {
        return dateItemAdded;
    }

    public void setDateItemAdded(String dateItemAdded) {
        this.dateItemAdded = dateItemAdded;
    }
}
