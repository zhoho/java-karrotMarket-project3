package com.example.crud;

import com.example.constant.Constant;
import com.example.database.DMLService;
import com.example.view.InputView;

public class Delete {
    public static void deleteItem() {
        InputView.getItemSeller();
        InputView.getDeleteItemIndex();
    }

    public static void deleteCheck(String input, int indexForDelete) {
        if(input.equals("Yes")) {
            if(DMLService.delete(indexForDelete) > Constant.ZERO) {
                System.out.println("삭제 성공!");
            }
            else {
                System.out.println("삭제 실패!");
            }
        }
    }
}
