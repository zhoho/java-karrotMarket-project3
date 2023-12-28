package com.example.crud;
import com.example.Item;
import com.example.view.InputView;

public class Update {
    public static void updateItem() {
        InputView.getItemSeller();
        InputView.getEditItemIndex();
    }

    public static void editToInput(int indexForEdit, String input, int idx) {
        if (!input.trim().isEmpty()) {
            Item.items.get(indexForEdit).set(idx, input);
        }
    }
}
