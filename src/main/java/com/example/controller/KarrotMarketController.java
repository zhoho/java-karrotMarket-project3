package com.example.controller;

import com.example.constant.Constant;
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
            String selectedMenu = InputView.selectMenu();
            if(Integer.parseInt(selectedMenu) == Constant.ZERO) {
                System.out.println(Constant.MENUEXIT);
                break;
            }
            menuRouter(Integer.parseInt(selectedMenu));
        }
    }

    public void menuRouter(int selectedMenu) {
            if(selectedMenu == Constant.ONE) {
                OutputView.printAllItems();
            }
            else if(selectedMenu == Constant.TWO) {
                Create.addItem();
            }
            else if(selectedMenu == Constant.THREE) {
                Update.updateItem();
            }
            else if(selectedMenu == Constant.FOUR) {
                Delete.deleteItem();
            }
            else if(selectedMenu == Constant.FIVE) {
                Read.searchItems(InputView.getItemName());
            }
            else {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력");
            }
    }
}
