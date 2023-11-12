package christmas.validate;

import java.util.Map;

import christmas.model.Food;

import java.util.List;

public class InputValidate {
    public void validateNull(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 아무 것도 입력되지 않았습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(String input) {
        Integer.parseInt(input);
    }

    public void validateRange(int input) {
        if (input < 1 || input > 31) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void validateMenuCount(int count) {
        if (count < 1) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateMenu(Map<Food, Integer> parseOrderFood, String name) {
        for (Food food : parseOrderFood.keySet()) {
            if (food.getName().equals(name)) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                throw new IllegalArgumentException();
            }
        }

    }

    public void validateOnlyDrink(List<Food> foods, Map<Food, Integer> parseOrderFood) {
        int drinkCount = 0;
        for (Food food : parseOrderFood.keySet()) {
            if (food.getCategory().equals("음료")) {
                drinkCount++;
            }
        }
        if (drinkCount == parseOrderFood.size()) {
            System.out.println("[ERROR] 음료만 주문할 수 없습니다.");
            throw new IllegalArgumentException();
        }

    }

    public void validateMenuOverflow(Map<Food, Integer> parseOrderFood) {
        int count = 0;
        for (Food key : parseOrderFood.keySet()) {
            count += parseOrderFood.get(key);
        }
        if (count > 20) {
            System.out.println("[ERROR] 20개 이상의 메뉴는 주문하실 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

}
