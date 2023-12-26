package com.example.view;

import com.example.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    public static final String PRINTMENU = "[1]상품 전체 보기\n[2]상품 추가\n[3]상품 수정\n[4]상품 등록 취소\n[5]상품 이름 검색\n[0]종료";
    public static final String PRINTADDITEMINFO = "[상품 추가]";
    public static final String INPUTSELLER = "판매자:";
    public static final String INPUTITEMNAME = "상품명:";
    public static final String INPUTPRICE = "판매가격:";
    public static final String INPUTDATE = "등록일자";
    public static final int ONE = 1;
    public static int id = 0;
    public static int selectMenu(){
        System.out.println(PRINTMENU);
        Scanner in = new Scanner(System.in);
        int seletedMenu = in.nextInt();
        return seletedMenu;
    }

    public static Item getItemInfo() {
        Scanner in = new Scanner(System.in);
        System.out.println(PRINTADDITEMINFO);

        System.out.print(INPUTSELLER);
        String seller = in.nextLine();

        System.out.print(INPUTITEMNAME);
        String itemName = in.nextLine();

        System.out.print(INPUTPRICE);
        int price = in.nextInt();
        increseId();
        Item item = new Item(id, seller, itemName, price);
        return item;
    }

    public static void increseId() {
        id += ONE;
    }
}
