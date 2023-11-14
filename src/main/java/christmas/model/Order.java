package christmas.model;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import christmas.parser.Parser;
import christmas.validate.InputValidate;

public class Order {

    public static Map<Food, Integer> takeOrder(String order) {
        Menu menu = new Menu();
        List<Food> foods = menu.initMenu();
        InputValidate inputValidate = new InputValidate();
        inputValidate.validateNull(order);
        Parser parser = new Parser();
        String[] orderFoods = parser.inputSplit(order);

        Map<Food, Integer> parseOrderFood = parseOrderFood(inputValidate, parser, orderFoods, order);
        inputValidate.validateMenuOverflow(parseOrderFood);
        inputValidate.validateOnlyDrink(foods, parseOrderFood);

        return parseOrderFood;
    }

    public static Map<Food, Integer> parseOrderFood(InputValidate inputValidate, Parser parser, String[] orderFoods,
            String order) {
        Menu menu = new Menu();
        List<Food> foods = menu.initMenu();
        Map<Food, Integer> parseOrderFood = new HashMap<>();
        for (int i = 0; i < orderFoods.length; i++) {
            String[] orderFood = parser.orderSplit(orderFoods[i]);
            String name = orderFood[0];
            inputValidate.validateMenuName(foods, name);
            Food food = menu.getFood(name);
            inputValidate.validateNumber(orderFood[1]);
            
            int count = parser.numberParser(orderFood[1]);
            inputValidate.validateMenuCount(count);
            inputValidate.validateDuplicateMenu(parseOrderFood, name);

            parseOrderFood.put(food, count);
        }

        return parseOrderFood;
    }
}
