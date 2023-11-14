package christmas.constant;

public enum ConstantMessage {

    INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_MENU("<주문 메뉴>"),
    COUNT("개"),
    DECEMBER("12월 "),
    BENEFIT_PREVIEW("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    BEFORE_BENEFIT_TOTAL_MONEY("<할인 전 총주문 금액>"),
    WON("원"),
    GIFT_MENU("<증정 메뉴>"),
    ONE_CHAMPAGNE("샴페인 1개"),
    NOTHING("없음"),
    BENEFIT_LIST("<혜택 내역>"),
    CHRISTMAS_BENEFIT_DISCOUNT("크리스마스 디데이 할인: -"),
    GIFT_BENEFIT_DISCOUNT("증정 이벤트: -"),
    WEEKDAY_DISCOUNT("평일 할인: -"),
    WEEKEND_DISCOUNT("주말 할인: -"),
    SPECIAL_DISCOUNT("특별 할인: -"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    MINUS("-"),
    AFTER_BENEFIT_TOTAL_MONEY("<할인 후 예상 결제 금액>"),
    SANTA("산타"),
    TREE("트리"),
    STAR("별"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    DRINK("음료"),
    MAIN("메인"),
    DESSERT("디저트");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
