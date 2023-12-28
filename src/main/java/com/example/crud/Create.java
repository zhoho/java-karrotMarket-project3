package com.example.crud;

import com.example.Item;
import com.example.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;

public class Create {
    public static void addItem() {
        Item item = InputView.getItemInfo();
        addToItemList(item);
    }

    public static void addToItemList(Item item) {
        Item.items.add(new ArrayList<>(Arrays.asList(
                String.valueOf(item.getId()),
                item.getSeller(),
                item.getItemName(),
                String.valueOf(item.getPrice()),
                item.getDateTime()
        )));
    }
}