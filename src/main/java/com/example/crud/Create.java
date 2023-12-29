package com.example.crud;

import com.example.Item;
import com.example.view.InputView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Create {
    public static void addItem() {
        InputView.getItemInfo();
    }

    public static void addToItemList(int id, String seller, String itemName, int price) {
        Item newitem = new Item(id, seller, itemName, price);
        Item.items.add(newitem);
    }
}