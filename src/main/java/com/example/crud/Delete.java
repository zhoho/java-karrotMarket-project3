package com.example.crud;

import com.example.constant.Constant;
import com.example.Item;
import com.example.view.InputView;

public class Delete {
    public static void deleteItem() {
        InputView.getItemSeller();
        InputView.getDeleteItemIndex();
    }

    public static void deleteCheck(String input, int indexForDelete) {
        if(input.equals("Yes")) {
            deleteExecute(indexForDelete);
        }
    }

    public static void deleteExecute(int indexForDelete) {
        Item.items.remove(indexForDelete - Constant.ONE);
    }
}
