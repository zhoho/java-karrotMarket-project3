package com.example.crud;

import com.example.Item;
import com.example.view.OutputView;

public class Read {
    public static void searchItems(String itemName) {
        for (Item item : Item.items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                OutputView.printMatchItemSeller(item);
            }
        }
    }

    public static void searchseller(String seller) {
        for (Item item : Item.items) {
            if (item.getSeller().equalsIgnoreCase(seller)) {
                OutputView.printMatchItemName(item);
            }
        }
    }
}
