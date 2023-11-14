package christmas.model;

import static christmas.constant.ConstantMessage.DESSERT;
import static christmas.constant.ConstantMessage.MAIN;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Event {

    public int getSumPrice(Map<Food, Integer> orderFood) {
        int sumPrice = 0;
        for (Food food : orderFood.keySet()) {
            sumPrice += (food.getPrice() * orderFood.get(food));
        }
        return sumPrice;
    }

    public boolean checkEventQualify(int sumPrice) {
        final int QUALIFICATION_PRICE = 10000;
        if (sumPrice < QUALIFICATION_PRICE) {
            return false;
        }
        return true;
    }

    public boolean checkChristmasEvent(int date) {
        final int CHRISTMAS_DATE = 25;
        if (date > CHRISTMAS_DATE) {
            return false;
        }
        return true;
    }

    public int getChristmasEventBenefitAmount(int date) {
        final int BASIC_DISCOUNT = 1000;
        final int DISCOUNT = 100;
        final int ONE = 1;
        int benefitAmount = BASIC_DISCOUNT + (DISCOUNT * (date - ONE));
        return benefitAmount;
    }

    public boolean checkGiftEvent(int sumPrice) {
        final int QUALIFICATION_PRICE = 120000;
        if (sumPrice < QUALIFICATION_PRICE) {
            return false;
        }
        return true;
    }

    public int getGiftEventBenefitAmount() {
        final int GIFT_PRICE = 25000;
        return GIFT_PRICE;
    }

    public boolean checkWeekday(int dayOfWeekNumber) {
        final int FRIDAY = 5;
        final int SATURDAY = 6;
        if (dayOfWeekNumber == FRIDAY || dayOfWeekNumber == SATURDAY) {
            return false;
        }
        return true;
    }

    public boolean checkSpecialEvent(int date) {
        final List<Integer> SPECIAL_DATES = List.of(3, 10, 17, 24, 25, 31);
        if (!SPECIAL_DATES.contains(date)) {
            return false;
        }
        return true;
    }

    public int getSpecialEventBenefitAmount() {
        final int DISCOUNT_AMOUNT = 1000;
        return DISCOUNT_AMOUNT;
    }

    public int getDessertCount(Map<Food, Integer> orderFood) {
        int dessertCount = 0;
        for (Food food : orderFood.keySet()) {
            if (food.getCategory().equals(DESSERT.getMessage())) {
                dessertCount += orderFood.get(food);
            }
        }
        return dessertCount;
    }

    public int getWeekdayBenefitAmount(int dessertCount) {
        final int DISCOUNT_DESSERT = 2023;
        int benefitAmount = DISCOUNT_DESSERT * dessertCount;
        return benefitAmount;
    }

    public int getMainMenuCount(Map<Food, Integer> orderFood) {
        int mainMenuCount = 0;
        for (Food food : orderFood.keySet()) {
            if (food.getCategory().equals(MAIN.getMessage())) {
                mainMenuCount += orderFood.get(food);
            }
        }
        return mainMenuCount;
    }

    public int getWeekendBenefitAmount(int mainMenuCount) {
        final int DISCOUNT_MAIN_MENU = 2023;
        int benefitAmount = DISCOUNT_MAIN_MENU * mainMenuCount;
        return benefitAmount;
    }

    public int getWeekNumber(int date) {
        final int YEAR = 2023;
        final int DECEMBER = 12;
        LocalDate calendar = LocalDate.of(YEAR, DECEMBER, date);
        DayOfWeek dayOfWeek = calendar.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        return dayOfWeekNumber;
    }

    public int getbadge(int totalBenefitAmount) {
        final int SANTA_MONEY = 20000;
        final int TREE_MONEY = 10000;
        final int STAR_MONEY = 5000;
        final int NOTHING = 0;
        if (totalBenefitAmount >= SANTA_MONEY) {
            return SANTA_MONEY;
        }
        if (totalBenefitAmount >= TREE_MONEY) {
            return TREE_MONEY;
        }
        if (totalBenefitAmount >= STAR_MONEY) {
            return STAR_MONEY;
        }
        return NOTHING;
    }
}
