package christmas.model;

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
        if (sumPrice < 10000) {
            return false;
        }
        return true;
    }

    public boolean checkChristmasEvent(int date) {
        if (date > 25) {
            return false;
        }
        return true;
    }

    public int getChristmasEventBenefitAmount(int date) {
        int basicDiscount = 1000;
        int discount = 100;
        int benefitAmount = basicDiscount + (discount * (date - 1));
        return benefitAmount;
    }

    public boolean checkGiftEvent(int sumPrice) {
        if (sumPrice < 120000) {
            return false;
        }
        return true;
    }

    public int getGiftEventBenefitAmount() {
        int giftPrice = 25000;
        return giftPrice;
    }

    public boolean checkWeekday(int dayOfWeekNumber) {
        if (dayOfWeekNumber == 5 || dayOfWeekNumber == 6) {
            return false;
        }
        return true;
    }

    public boolean checkSpecialEvent(int date) {
        List<Integer> specialDates = List.of(3, 10, 17, 24, 25, 31);
        if (!specialDates.contains(date)) {
            return false;
        }
        return true;
    }

    public int getSpecialEventBenefitAmount() {
        int discountAmount = 1000;
        return discountAmount;
    }

    public int getDessertCount(Map<Food, Integer> orderFood) {
        int dessertCount = 0;
        for (Food food : orderFood.keySet()) {
            if (food.getCategory().equals("디저트")) {
                dessertCount += orderFood.get(food);
            }
        }
        return dessertCount;
    }

    public int getWeekdayBenefitAmount(int dessertCount) {
        int discountDessert = 2023;
        int benefitAmount = discountDessert * dessertCount;
        return benefitAmount;
    }

    public int getMainMenuCount(Map<Food, Integer> orderFood) {
        int mainMenuCount = 0;
        for (Food food : orderFood.keySet()) {
            if (food.getCategory().equals("메인")) {
                mainMenuCount += orderFood.get(food);
            }
        }
        return mainMenuCount;
    }

    public int getWeekendBenefitAmount(int mainMenuCount) {
        int discountMainMenu = 2023;
        int benefitAmount = discountMainMenu * mainMenuCount;
        return benefitAmount;
    }

    public int getWeekNumber(int date) {
        LocalDate calendar = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = calendar.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        return dayOfWeekNumber;
    }

    public String getbadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return "산타";
        }
        if (totalBenefitAmount >= 10000) {
            return "트리";
        }
        if (totalBenefitAmount >= 5000) {
            return "별";
        }
        return "없음";
    }
}
