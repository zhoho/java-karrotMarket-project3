package com.example.view;

import com.example.constant.Constant;
import com.example.Item;
import com.example.constant.ErrorMessage;

import java.util.ArrayList;

public class OutputView {
    public static final String PRINTSTARTMESSAGE = "당근마켓에 오신것을 환영합니다 메뉴를 선택해주세요";
    public static final String DIVISIONLINE = "--------------------------------------";
    public static final String PRINTSELLER = "판매자 : ";
    public static final String PRINTITEMNAME = "상품명 : ";
    public static final String PRINTPRICE = "가격 : ";
    public static final String PRINTREGISTERTIME = "등록 일자 : ";
    public static void printStartMessage() {
        System.out.println(PRINTSTARTMESSAGE);
    }

    public static void printAllItems() {
        itemEmptyCheck();
        for(int i = Constant.ZERO; i < Item.items.size(); i++) {
            System.out.println(DIVISIONLINE);
            System.out.println(i + Constant.ONE);
            System.out.println(PRINTSELLER + Item.items.get(i).getSeller());
            System.out.println(PRINTITEMNAME + Item.items.get(i).getItemName());
            System.out.println(PRINTPRICE + Item.items.get(i).getPrice());
//            System.out.println(PRINTREGISTERTIME + Item.items.get(i).getDateTime());
            System.out.println(DIVISIONLINE);
        }
    }

    public static void itemEmptyCheck() {
        if(Item.items.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ITEMS_EMPTY.getMessage());
        }
    }

//    public static void printMatchItemSeller(String seller) {
//        int idIndex = Constant.ONE;
//        for (ArrayList<Object> list : Item.items) {
//            if (!list.isEmpty() && list.get(list.size() - Constant.FOUR).equals(seller)) {
//                System.out.println(DIVISIONLINE);
//                System.out.println(idIndex);
//                System.out.println(PRINTSELLER + list.get(1));
//                System.out.println(PRINTITEMNAME + list.get(2));
//                System.out.println(PRINTPRICE + list.get(3));
//                System.out.println(PRINTREGISTERTIME + list.get(4));
//                System.out.println(DIVISIONLINE);
//                idIndex++;
//            }
//        }
//    }
//
//    public static void printMatchItemName(String itemName) {
//        int idIndex = Constant.ONE;
//        for (ArrayList<Object> list : Item.items) {
//            if (!list.isEmpty() && list.get(list.size() - Constant.THREE).equals(itemName)) {
//                System.out.println(DIVISIONLINE);
//                System.out.println(idIndex);
//                System.out.println(PRINTSELLER + list.get(1));
//                System.out.println(PRINTITEMNAME + list.get(2));
//                System.out.println(PRINTPRICE + list.get(3));
//                System.out.println(PRINTREGISTERTIME + list.get(4));
//                System.out.println(DIVISIONLINE);
//                idIndex++;
//            }
//        }
//    }
}
