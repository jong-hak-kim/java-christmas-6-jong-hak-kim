package christmas.controller;

import java.util.Map;

import christmas.model.Event;
import christmas.model.Food;
import christmas.model.Order;
import christmas.parser.Parser;
import christmas.view.InputView;

public class ChristmasController {

    private InputView inputView;
    private Order order;
    private Event event;

    public ChristmasController() {
        this.inputView = new InputView();
        this.order = new Order();
        this.event = new Event();
    }

    public void run() {
        int date = inputDate();
        Map<Food, Integer> order = inputMenu();
        getEvent(date, order);
    }

    public int inputDate() {
        while (true) {
            try {
                int input = inputView.readDate();
                return input;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
        }
    }

    public Map<Food, Integer> inputMenu() {
        while (true) {
            try {
                String input = inputView.readMenu();
                return Order.takeOrder(input);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
        }
    }

    public void getEvent(int date, Map<Food, Integer> order) {

        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        int sumPrice = event.getSumPrice(order);
        int dayOfWeekNumber = event.getWeekNumber(date);
        int totalBenefitAmount = 0;

        System.out.println("<주문 메뉴>");
        for (Food food : order.keySet()) {
            System.out.println(food.getName() + " " + order.get(food) + "개");
        }

        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Parser.parseNumberFormat(sumPrice) + "원");

        System.out.println();
        System.out.println("<증정 메뉴>");
        boolean hasGiftEvent = event.checkGiftEvent(sumPrice);
        if (hasGiftEvent) {
            System.out.println("샴페인 1개");
        }
        if (!hasGiftEvent) {
            System.out.println("없음");
        }

        System.out.println();
        System.out.println("<혜택 내역>");
        if (event.checkEventQualify(sumPrice)) {
            if (event.checkChristmasEvent(date)) {
                int christmasEventBenefitAmount = event.getChristmasEventBenefitAmount(date);
                totalBenefitAmount += christmasEventBenefitAmount;
                System.out.println("크리스마스 디데이 할인: -" + Parser.parseNumberFormat(christmasEventBenefitAmount) + "원");
            }
            if (event.checkGiftEvent(sumPrice)) {
                int giftEventBenefitAmount = event.getGiftEventBenefitAmount();
                totalBenefitAmount += giftEventBenefitAmount;
                System.out.println("증정 이벤트: -" + Parser.parseNumberFormat(giftEventBenefitAmount) + "원");
            }
            if (event.checkWeekday(dayOfWeekNumber)) {
                int getDessertCount = event.getDessertCount(order);
                int weekdayBenefitAmount = event.getWeekdayBenefitAmount(getDessertCount);
                totalBenefitAmount += weekdayBenefitAmount;
                System.out.println("평일 할인: -" + Parser.parseNumberFormat(weekdayBenefitAmount) + "원");
            }
            if (!event.checkWeekday(dayOfWeekNumber)) {
                int getMainMenuCount = event.getMainMenuCount(order);
                int weekendBenefitAmount = event.getWeekendBenefitAmount(getMainMenuCount);
                totalBenefitAmount += weekendBenefitAmount;
                System.out.println("주말 할인: -" + Parser.parseNumberFormat(weekendBenefitAmount) + "원");
            }
            if (event.checkSpecialEvent(date)) {
                int specialEventBenefitAmount = event.getSpecialEventBenefitAmount();
                totalBenefitAmount += specialEventBenefitAmount;
                System.out.println("특별 할인: -" + Parser.parseNumberFormat(specialEventBenefitAmount) + "원");
            }
        }
        if (!event.checkEventQualify(sumPrice)) {
            System.out.println("없음");
        }

        System.out.println();
        System.out.println("<총혜택 금액>");
        if (totalBenefitAmount == 0) {
            System.out.println(Parser.parseNumberFormat(totalBenefitAmount) + "원");
        }
        if (totalBenefitAmount > 0) {
            System.out.println("-" + Parser.parseNumberFormat(totalBenefitAmount) + "원");
        }

        System.out.println();
        int sumDiscountPrice = 0;
        if (hasGiftEvent) {
            sumDiscountPrice = sumPrice - totalBenefitAmount - event.getGiftEventBenefitAmount();
        }
        if (!hasGiftEvent) {
            sumDiscountPrice = sumPrice - totalBenefitAmount;
        }
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(Parser.parseNumberFormat(sumDiscountPrice) + "원");

        System.out.println();
        String badge = event.getbadge(totalBenefitAmount);
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
