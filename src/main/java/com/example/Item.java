package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Item {
    private int id;
    private String seller;
    private int price;
    private String itemName;
    private LocalDateTime dateTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일 HH시 mm분");


    public Item(int id, String seller, String itemName, int price) {
        this.id = id;
        this.seller = seller;
        this.price = price;
        this.itemName = itemName;
        this.dateTime = LocalDateTime.now();

    }
    public int getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateTime() {
        return dateTime.format(formatter);
    }

    public static ArrayList<ArrayList<Object>> items = new ArrayList<>();

}
