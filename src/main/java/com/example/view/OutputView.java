package com.example.view;

import com.example.constant.Constant;
import com.example.Item;
import com.example.constant.ErrorMessage;
import com.example.database.DQLService;

public class OutputView {
    public static final String PRINTSTARTMESSAGE = "당근마켓에 오신것을 환영합니다 메뉴를 선택해주세요";
    public static final String DIVISIONLINE = "--------------------------------------";
    public static final String PRINTSELLER = "판매자 : ";
    public static final String PRINTITEMNAME = "상품명 : ";
    public static final String PRINTPRICE = "가격 : ";
    public static final String PRINTREGISTERTIME = "등록 일자 : ";

    public static final String PRINTSUCCESSADD = "상품 추가 성공!";
    public static final String PRINTFAILADD = "상품 추가 실패!";
    public static final String PRINTSUCCESSEDIT = "상품 수정 성공!";
    public static final String PRINTFAILEDIT = "상품 수정 실패!";
    public static final String PRINTSUCCESSDELETE = "상품 삭제 성공!";
    public static final String PRINTFAILDELETE = "상품 삭제 실패!";

    public static void printStartMessage() {
        System.out.println(PRINTSTARTMESSAGE);
    }

    public static void printItems() {
        itemEmptyCheck();
        for(int i = Constant.ZERO; i < Item.items.size(); i++) {
            System.out.println(DIVISIONLINE);
            System.out.println(i + Constant.ONE);
            System.out.println(PRINTSELLER + Item.items.get(i).getSeller());
            System.out.println(PRINTITEMNAME + Item.items.get(i).getItemName());
            System.out.println(PRINTPRICE + Item.items.get(i).getPrice());
            System.out.println(PRINTREGISTERTIME + Item.items.get(i).getDateTime());
            System.out.println(DIVISIONLINE);
        }
    }

    public static void itemEmptyCheck() {
        if(Item.items.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ITEMS_EMPTY.getMessage());
        }
    }

    public static void dbAddExecutionCheck(int checker) {
        if(checker > 0) {
            System.out.println(PRINTSUCCESSADD);
        }
        else{
            System.out.println(PRINTFAILADD);
        }
    }

    public static void dbDeleteExecutionCheck(int checker) {
        if(checker > 0) {
            System.out.println(PRINTSUCCESSDELETE);
        }
        else{
            System.out.println(PRINTFAILDELETE);
        }
    }

    public static void dbEditExecutionCheck(int checker) {
        if(checker > 0) {
            System.out.println(PRINTSUCCESSEDIT);
        }
        else{
            System.out.println(PRINTFAILEDIT);
        }
    }
}
