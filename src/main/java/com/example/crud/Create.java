package com.example.crud;

import com.example.Item;
import com.example.view.InputView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Create {
    public static final String DATEFORMAT = "M월 d일 HH시 mm분";
    public static void addItem() {
        InputView.getItemInfo();
    }

    public static void addToItemList(int id, String seller, String itemName, int price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        Item newitem = new Item(id, seller, itemName, price, formattedDateTime);
        Item.items.add(newitem);
    }
}