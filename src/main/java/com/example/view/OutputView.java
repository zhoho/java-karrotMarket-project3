package com.example.view;

import com.example.Constant.constant;
import com.example.Item;

import java.util.ArrayList;

public class OutputView {
    public static final String PRINTSTARTMESSAGE = "당근마켓에 오신것을 환영합니다 메뉴를 선택해주세요";
    public static final String DIVISIONLINE = "--------------------------------------";
    public static final String PRINTSELLER = "판매자 : ";
    public static final String PRINTITEMNAME = "상품명 : ";
    public static final String PRINTPRICE = "가격 : ";
    public static final String ITEMSEMPTY = "[ERROR] 현재 등록된 상품이 없습니다!";

    public static void printStartMessage() {
        System.out.println(PRINTSTARTMESSAGE);
    }

    public static void printAllItems() {
        itemEmptyCheck();
        for(int i = constant.ZERO; i < Item.items.size(); i++) {
            System.out.println(DIVISIONLINE);
            System.out.println(Item.items.get(i).get(0));
            System.out.println(PRINTSELLER + Item.items.get(i).get(1));
            System.out.println(PRINTITEMNAME + Item.items.get(i).get(2));
            System.out.println(PRINTPRICE + Item.items.get(i).get(3));
            System.out.println(DIVISIONLINE);
        }
    }

    public static void itemEmptyCheck() {
        if(Item.items.isEmpty()) {
            throw new IllegalArgumentException(ITEMSEMPTY);
        }
    }

    public static void findMatchItemSeller(String sellerForEdit) {
        for (ArrayList<Object> list : Item.items) {
            if (!list.isEmpty() && list.get(list.size() - constant.THREE).equals(sellerForEdit)) {
                System.out.println(DIVISIONLINE);
                System.out.println(list.get(0));
                System.out.println(PRINTSELLER + list.get(1));
                System.out.println(PRINTITEMNAME + list.get(2));
                System.out.println(PRINTPRICE + list.get(3));
                System.out.println(DIVISIONLINE);
            }
        }
    }
}
