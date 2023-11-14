package christmas.view;

import static christmas.constant.ConstantMessage.*;

import java.util.Map;

import christmas.constant.ConstantMessage;
import christmas.model.Food;

public class OutputView {
    private final static int SANTA_MONEY = 20000;
    private final static int TREE_MONEY = 10000;
    private final static int STAR_MONEY = 5000;
    private final static int NOTHING_MONEY = 0;

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static void printInit() {
        printConstantMessage(INTRODUCE);
    }

    public static void printEventPreview(int date) {
        System.out.println(DECEMBER.getMessage() + date + BENEFIT_PREVIEW.getMessage());
    }

    public static void printMenu(Map<Food, Integer> order) {
        System.out.println();
        printConstantMessage(ORDER_MENU);
        for (Food food : order.keySet()) {
            System.out.println(food.getName() + " " + order.get(food) + COUNT.getMessage());
        }
    }

    public static void printBeforeBeneiftMoney(String sumPrice) {
        System.out.println();
        printConstantMessage(BEFORE_BENEFIT_TOTAL_MONEY);
        System.out.println(sumPrice + WON.getMessage());
    }

    public static void printGiftMenu(boolean hasGiftEvent) {
        System.out.println();
        printConstantMessage(GIFT_MENU);
        if (hasGiftEvent) {
            printConstantMessage(ONE_CHAMPAGNE);
        }
        if (!hasGiftEvent) {
            printNothing();
        }
    }

    public static void printBenefitList() {
        System.out.println();
        printConstantMessage(BENEFIT_LIST);
    }

    public static void printChristmasDiscount(String christmasEventBenefitAmount) {
        System.out.println(CHRISTMAS_BENEFIT_DISCOUNT.getMessage() + christmasEventBenefitAmount + WON.getMessage());
    }

    public static void printGiftDiscount(String giftEventBenefitAmount) {
        System.out.println(GIFT_BENEFIT_DISCOUNT.getMessage() + giftEventBenefitAmount + WON.getMessage());
    }

    public static void printWeekdayDiscount(String weekdayBenefitAmount) {
        System.out.println(WEEKDAY_DISCOUNT.getMessage() + weekdayBenefitAmount + WON.getMessage());
    }

    public static void printWeekendDiscount(String weekendBenefitAmount) {
        System.out.println(WEEKEND_DISCOUNT.getMessage() + weekendBenefitAmount + WON.getMessage());
    }

    public static void printSpecialDiscount(String specialEventBenefitAmount) {
        System.out.println(SPECIAL_DISCOUNT.getMessage() + specialEventBenefitAmount + WON.getMessage());
    }

    public static void printNothing() {
        printConstantMessage(NOTHING);
    }

    public static void printTotalBenefitAmount(String totalBenefitAmount) {
        final String MIN_MONEY = "0";
        System.out.println();
        printConstantMessage(TOTAL_BENEFIT_AMOUNT);
        if (totalBenefitAmount.equals(MIN_MONEY)) {
            System.out.println(totalBenefitAmount + WON.getMessage());
        }
        if (!totalBenefitAmount.equals(MIN_MONEY)) {
            System.out.println(MINUS.getMessage() + totalBenefitAmount + WON.getMessage());
        }
    }

    public static void printAfterBenefitTotalMoney(String sumDiscountPrice) {
        System.out.println();
        printConstantMessage(AFTER_BENEFIT_TOTAL_MONEY);
        System.out.println(sumDiscountPrice + WON.getMessage());
    }

    public static void printBadge(int badgeMoney) {
        System.out.println();
        printConstantMessage(DECEMBER_EVENT_BADGE);
        if (badgeMoney == SANTA_MONEY) {
            printConstantMessage(SANTA);
        }
        if (badgeMoney == TREE_MONEY) {
            printConstantMessage(TREE);
        }
        if (badgeMoney == STAR_MONEY) {
            printConstantMessage(STAR);
        }
        if (badgeMoney == NOTHING_MONEY) {
            printConstantMessage(NOTHING);
        }
    }

}
