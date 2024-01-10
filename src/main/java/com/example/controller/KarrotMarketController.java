package com.example.controller;

import com.example.constant.Constant;
import com.example.constant.ErrorMessage;
import com.example.crud.Create;
import com.example.crud.Delete;
import com.example.crud.Read;
import com.example.crud.Update;
import com.example.database.DQLService;
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
                DQLService.getAllData();
                OutputView.printItems();
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
            else if(selectedMenu == Constant.SIX) {
                Read.searchItemsOrderedIncreasing();
            }
            else {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
    }
}
