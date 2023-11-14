package christmas.validate;

import java.util.Map;

import christmas.exception.ErrorMessage;
import christmas.model.Food;

import static christmas.exception.ErrorMessage.*;
import static christmas.constant.ConstantMessage.DRINK;

import java.util.List;

public class InputValidate {

    public static void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getErrorMessage());
    }

    public void validateNull(String input) {
        if (input.isBlank()) {
            printErrorMessage(INPUT_NOTHING);
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(String input) {
        Integer.parseInt(input);
    }

    public void validateRange(int input) {
        final int MIN_DATE = 1;
        final int MAX_DATE = 31;
        if (input < MIN_DATE || input > MAX_DATE) {
            printErrorMessage(INCORRECT_DATE);
            throw new IllegalArgumentException();
        }
    }

    public void validateMenuName(List<Food> foods, String name) {
        boolean hasMenu = false;
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            if (food.getName().equals(name)) {
                hasMenu = true;
            }
        }
        if (!hasMenu) {
            printErrorMessage(INCORRECT_ORDER);
            throw new IllegalArgumentException();
        }
    }

    public void validateMenuCount(int count) {
        int LEAST_MENU_COUNT = 1;
        if (LEAST_MENU_COUNT < 1) {
            printErrorMessage(INCORRECT_ORDER);
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateMenu(Map<Food, Integer> parseOrderFood, String name) {
        for (Food food : parseOrderFood.keySet()) {
            if (food.getName().equals(name)) {
                printErrorMessage(INCORRECT_ORDER);
                throw new IllegalArgumentException();
            }
        }

    }

    public void validateOnlyDrink(List<Food> foods, Map<Food, Integer> parseOrderFood) {
        int drinkCount = 0;
        for (Food food : parseOrderFood.keySet()) {
            if (food.getCategory().equals(DRINK.getMessage())) {
                drinkCount++;
            }
        }
        if (drinkCount == parseOrderFood.size()) {
            printErrorMessage(ONLY_ORDER_DRINK);
            throw new IllegalArgumentException();
        }

    }

    public void validateMenuOverflow(Map<Food, Integer> parseOrderFood) {
        final int MAX_MENU_COUNT = 20;
        int count = 0;
        for (Food key : parseOrderFood.keySet()) {
            count += parseOrderFood.get(key);
        }
        if (count > MAX_MENU_COUNT) {
            printErrorMessage(OVER_TWENTY_MENU);
            throw new IllegalArgumentException();
        }
    }

}
