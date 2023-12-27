package com.example.controller;

import com.example.Constant.constant;
import com.example.crud.Create;
import com.example.crud.Delete;
import com.example.crud.Read;
import com.example.crud.Update;
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
                System.out.println(constant.MENUEXIT);
                break;
            }
            menuRouter(selectedMenu);
        }
    }

    public void menuRouter(int selectedMenu) {
            if(selectedMenu == constant.ONE) {
                OutputView.printAllItems();
            }
            else if(selectedMenu == constant.TWO) {
                Create.addItem();
            }
            else if(selectedMenu == constant.THREE) {
                Update.updateItem();
            }
            else if(selectedMenu == constant.FOUR) {
                Delete.deleteItem();
            }
            else if(selectedMenu == constant.FIVE) {
                Read.searchItems();
            }
            else {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력");
            }
    }
}
