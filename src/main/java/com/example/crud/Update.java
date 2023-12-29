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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        if (!seller.isEmpty()) Item.items.get(indexForEdit-Constant.ONE).setSeller(seller);
        if (!itemName.isEmpty()) Item.items.get(indexForEdit-Constant.ONE).setItemName(itemName);
        if (!price.isEmpty()) Item.items.get(indexForEdit-Constant.ONE).setPrice(Integer.parseInt(price));
        Item.items.get(indexForEdit-Constant.ONE).setDateTiem(formattedDateTime);
    }
}
