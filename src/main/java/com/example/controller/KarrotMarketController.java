package com.example.controller;

import com.example.Constant.constant;
import com.example.Create;
import com.example.view.InputView;
import com.example.view.OutputView;

public class KarrotMarketController {
    public KarrotMarketController() {
        OutputView.printStartMessage();
    }

    public void karrotFlow() {
        while(true) {
            int selectedMenu = InputView.selectMenu();

            if(selectedMenu == constant.ZERO) {
                System.out.println("종료하기");
                break;
            }
            menuRouter(selectedMenu);
        }
    }

    public void menuRouter(int selectedMenu) {
            if(selectedMenu == constant.ONE) {
                System.out.println("조회하기");
            }
            else if(selectedMenu == constant.TWO) {
                Create.addItem();
            }
            else if(selectedMenu == constant.THREE) {
                System.out.println("수정하기");
            }
            else if(selectedMenu == constant.FOUR) {
                System.out.println("삭제하기");
            }
            else if(selectedMenu == constant.FIVE) {
                System.out.println("검색하기");
            }
            else {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력");
            }
    }
}
