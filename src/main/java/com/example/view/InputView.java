package com.example.view;

import com.example.Constant.constant;
import com.example.Item;
import com.example.Update;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    public static final String PRINTMENU = "[1]상품 전체 보기\n[2]상품 추가\n[3]상품 수정\n[4]상품 등록 취소\n[5]상품 이름 검색\n[0]종료";
    public static final String PRINTADDITEMINFO = "[상품 추가]";
    public static final String PRINTEDITITEMINFO = "[상품 수정]";
    public static final String INPUTSELLER = "판매자:";
    public static final String INPUTITEMNAME = "상품명:";
    public static final String INPUTPRICE = "판매가격:";
    public static final String INPUTDATE = "등록일자";
    public static final String PRINTEDITMESSAGE = "수정할 제품의 판매자를 입력해 주세요";
    public static final String PRINTEDITITEMINDEX = "수정할 제품의 번호를 입력해 주세요";
    public static final String ENTER = "\n";
    public static int id = constant.ZERO;
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
        id += constant.ONE;
    }

    public static void getItemSeller() {
        Scanner in = new Scanner(System.in);
        System.out.print(PRINTEDITMESSAGE + ENTER + INPUTSELLER);
        String sellerForEdit = in.nextLine();
        OutputView.findMatchItemSeller(sellerForEdit);
    }

    public static void getEditItemIndex() {
        Scanner in = new Scanner(System.in);
        System.out.println(PRINTEDITITEMINDEX);
        int indexForEdit = in.nextInt();
        findMatchItemIndex(indexForEdit);
    }

    public static void findMatchItemIndex(int indexForEdit) {
        Scanner in = new Scanner(System.in);
        indexForEdit -= constant.ONE;
        System.out.println(PRINTEDITITEMINFO);

        System.out.print(INPUTSELLER);
        String seller = in.nextLine();
        Update.editToInput(indexForEdit, seller);

        System.out.print(INPUTITEMNAME);
        String itemName = in.nextLine();
        Update.editToInput(indexForEdit, itemName);

        System.out.print(INPUTPRICE);
        String price = in.nextLine();
        Update.editToInput(indexForEdit, price);
    }
}
