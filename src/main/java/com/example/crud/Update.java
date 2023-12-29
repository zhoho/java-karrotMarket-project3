package com.example.crud;
import com.example.Item;
import com.example.constant.Constant;
import com.example.view.InputView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Update {
    public static final String DATEFORMAT = "M월 d일 HH시 mm분";
    public static void updateItem() {
        InputView.getItemSeller();
        InputView.getEditItemIndex();
    }

    public static void editToInput(int indexForEdit, String seller, String itemName, String price) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
//        String formattedDateTime = LocalDateTime.now().format(formatter);
        if (!seller.isEmpty()) Item.items.get(indexForEdit-1).setSeller(seller);
        if (!itemName.isEmpty()) Item.items.get(indexForEdit-1).setItemName(itemName);
        if (!price.isEmpty()) Item.items.get(indexForEdit-1).setPrice(Integer.parseInt(price));
//        if (!seller.trim().isEmpty()) {
//            Item.items.get(indexForEdit).set(seller);
//        }
//        Item.items.get(indexForEdit).set(Constant.FOUR, formattedDateTime);
    }
}
