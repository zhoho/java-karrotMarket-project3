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
}
