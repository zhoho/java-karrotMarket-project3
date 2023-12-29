package com.example.crud;

import com.example.Item;
import com.example.view.InputView;
import com.example.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;


public class Read {
    public static void searchItems(String itemName) {
        List<Item> matchedItems = Item.items.stream()
                .filter(item -> item != null && item.getItemName().contains(itemName))
                .map(item -> (Item) item)
                .collect(Collectors.toList());
        OutputView.printMatchItemName(matchedItems);
    }

    public static void searchseller(String seller) {
        OutputView.printMatchItemSeller(Item.items.stream().filter(item -> item.getItemName().contains(seller)).toList());
    }
}
