package com.example.view;

import com.example.constant.Constant;
import com.example.constant.ErrorMessage;
import com.example.crud.Create;
import com.example.crud.Delete;
import com.example.Item;
import com.example.crud.Read;
import com.example.crud.Update;

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
    public static final String PRINTSELLERMESSAGE = "제품의 판매자를 입력해 주세요";
    public static final String PRINTEDITITEMINDEX = "수정할 제품의 번호를 입력해 주세요";
    public static final String PRINTDELETEINDEX = "삭제할 제품의 번호를 입력해 주세요";
    public static final String WARNINGDELETE = "정말로 삭제하시겠습니까? 삭제를 원하신다면 Yes를 입력해주세요";
    public static final String PRINTSEARCHITEMNAME = "검색할 제품의 이름을 입력해 주세요";
    public static final String ENTER = "\n";
    public static String selectMenu(){
        System.out.println(PRINTMENU);
        Scanner in = new Scanner(System.in);
        String selectedMenu;

        while (true) {
            selectedMenu = in.nextLine();
            try {
                Integer.parseInt(selectedMenu);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_MENU_SELECT.getMessage());
            }
        }
        return selectedMenu;
    }

    public static void getItemInfo() {
        System.out.println(PRINTADDITEMINFO);

        int id = getItemId();
        String seller = getItemInfoSeller();
        String itemName = getItemInfoItemName();
        int price = getItemInfoPrice();
        Create.addToItemList(id,seller,itemName,price);
    }

    public static int getItemId() {
        //db 구현시 수정
        int id;
        id = Item.items.size();
        return id;
    }

    public static String getItemInfoSeller() {
        Scanner in = new Scanner(System.in);
        String seller;
        while (true) {
            System.out.print(INPUTSELLER);
            seller = in.nextLine();
            if (!seller.trim().isEmpty()) {
                break;
            }
            System.out.println(ErrorMessage.SELLER_INPUT_EMPTY.getMessage());
        }
        return seller;
    }

    public static String getItemInfoItemName() {
        Scanner in = new Scanner(System.in);
        String itemName;
        while (true) {
            System.out.print(INPUTITEMNAME);
            itemName = in.nextLine();
            if (!itemName.trim().isEmpty()) {
                break;
            }
            System.out.println(ErrorMessage.ITEM_INPUT_EMPTY);
        }
        return itemName;
    }

    public static int getItemInfoPrice() {
        Scanner in = new Scanner(System.in);
        String price;
        int parsedPrice;
        while (true) {
            System.out.print(INPUTPRICE);
            price = in.nextLine();
            if (price.trim().isEmpty()) {
                System.out.println(ErrorMessage.PRICE_INPUT_EMPTY.getMessage());
                continue;
            }
            try {
                parsedPrice = Integer.parseInt(price);
                if (parsedPrice < Constant.ZERO || parsedPrice >= Constant.LIMITPRICE) {
                    System.out.println(ErrorMessage.INVALID_ITEM_PRICE.getMessage());
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_MENU_SELECT.getMessage());
            }
        }
        return Integer.parseInt(price);
    }

    public static void getItemSeller() {
        Scanner in = new Scanner(System.in);
        System.out.print(PRINTSELLERMESSAGE + ENTER + INPUTSELLER);
        String seller = in.nextLine();
        Read.searchseller(seller);
    }

    public static void getEditItemIndex() {
        Scanner in = new Scanner(System.in);
        System.out.println(PRINTEDITITEMINDEX);
        String indexForEdit;
        while (true) {
            indexForEdit = in.nextLine();
            try {
                Integer.parseInt(indexForEdit);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_MENU_SELECT.getMessage());
            }
        }
        findMatchItemIndex(Integer.parseInt(indexForEdit));
    }

    public static void findMatchItemIndex(int indexForEdit) {
        Scanner in = new Scanner(System.in);
        System.out.println(PRINTEDITITEMINFO);

        System.out.print(INPUTSELLER);
        String seller = in.nextLine();

        System.out.print(INPUTITEMNAME);
        String itemName = in.nextLine();

        System.out.print(INPUTPRICE);
        String price = in.nextLine();
        Update.editToInput(indexForEdit, seller, itemName, price);}

    public static void getDeleteItemIndex() {
        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);
        System.out.println(PRINTDELETEINDEX);
        int indexForDelete = in.nextInt();
        System.out.println(WARNINGDELETE);
        String input = on.nextLine();
        Delete.deleteCheck(input, indexForDelete);
    }

    public static String getItemName() {
        Scanner in = new Scanner(System.in);
        System.out.print(PRINTSEARCHITEMNAME + ENTER + INPUTITEMNAME);
        String itemName = in.nextLine();
        return itemName;
    }
}
