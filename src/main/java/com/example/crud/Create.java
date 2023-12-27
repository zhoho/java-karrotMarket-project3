package com.example.crud;

import com.example.Item;
import com.example.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;

public class Create {
    public static void addItem() {
        Item item = InputView.getItemInfo();
        addToItemList(item);
    }

    public static void addToItemList(Item item) {
        Item.items.add(new ArrayList<>(Arrays.asList(String.valueOf(item.getId()), item.getSeller(), item.getItemName(), String.valueOf(item.getPrice()))));
        System.out.println(Item.items);
        // 1
        // 제품명 : 에어프라이기
        // 가격 : 30000원
        // 등록자 : 최지호
    }
}
