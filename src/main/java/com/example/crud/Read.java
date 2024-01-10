package com.example.crud;
import com.example.database.DQLService;
import com.example.view.OutputView;


public class Read {
    public static void searchItems(String itemName) {
        DQLService.getDataIncludeItemName(itemName);
        OutputView.printItems();
    }

    public static void searchItemsOrderedIncreasing() {
        DQLService.getDataOrderedIncreasing();
        OutputView.printItems();
    }
}
