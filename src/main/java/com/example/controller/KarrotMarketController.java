package com.example.controller;

import com.example.Create;
import com.example.view.InputView;
import com.example.view.OutputView;

public class KarrotMarketController {
    public KarrotMarketController() {
        OutputView.printStartMessage();
    }

    public void karrotFlow() {
        int selectedMenu = InputView.selectMenu();
        menuRouter(selectedMenu);
    }

    public void menuRouter(int selectedMenu) {
        if(selectedMenu == 1) {
            System.out.println("조회하기");
        }
        else if(selectedMenu == 2) {
            Create.addItem();
        }
        else if(selectedMenu == 3) {
            System.out.println("수정하기");
        }
        else if(selectedMenu == 4) {
            System.out.println("삭제하기");
        }
        else if(selectedMenu == 5) {
            System.out.println("검색하기");
        }
        else if(selectedMenu == 0) {
            System.out.println("종료하기");
        }
        else {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력");
        }
    }
}
