package christmas.exception;

public enum ErrorMessage {
    
    INPUT_NOTHING("[ERROR] 아무 것도 입력되지 않았습니다."),
    INCORRECT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INCORRECT_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_ORDER_DRINK("[ERROR] 음료만 주문할 수 없습니다."),
    OVER_TWENTY_MENU("[ERROR] 20개 이상의 메뉴는 주문하실 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
