package com.example.constant;

public enum ErrorMessage {
    INVALID_MENU_SELECT("[ERROR] 숫자를 입력해 주세요"),
    INVALID_ITEM_PRICE("[ERROR] 상품 가격은 0원부터 1억원(100000000)이하 로만 설정 가능합니다."),
    ITEMS_EMPTY("[ERROR] 현재 등록된 상품이 없습니다!"),
    SELLER_INPUT_EMPTY("[ERROR] 판매자 이름은 공백일 수 없습니다. 다시 입력해주세요."),
    ITEM_INPUT_EMPTY("[ERROR] 상품 이름은 공백일 수 없습니다. 다시 입력해주세요."),
    PRICE_INPUT_EMPTY("[ERROR] 가격을 입력해야 합니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
