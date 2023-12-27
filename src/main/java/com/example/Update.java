package com.example;

import com.example.Constant.constant;
import com.example.view.InputView;
import com.example.view.OutputView;

public class Update {
    public static void updateItem() {
        InputView.getItemSeller();
        InputView.getEditItemIndex();
    }

    public static void editToInput(int indexForEdit, String input) {
        if (!input.trim().isEmpty()) {
            Item.items.get(indexForEdit).set(constant.ONE, input);
        }
    }
}
