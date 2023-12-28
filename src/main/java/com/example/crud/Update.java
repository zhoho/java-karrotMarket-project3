package com.example.crud;
import com.example.Item;
import com.example.constant.Constant;
import com.example.view.InputView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Update {
    public static final String DATEFORMAT = "M월 d일 HH시 mm분";
    public static void updateItem() {
        InputView.getItemSeller();
        InputView.getEditItemIndex();
    }

    public static void editToInput(int indexForEdit, String input, int idx) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        if (!input.trim().isEmpty()) {
            Item.items.get(indexForEdit).set(idx, input);
        }
        Item.items.get(indexForEdit).set(Constant.FOUR, formattedDateTime);
    }
}
