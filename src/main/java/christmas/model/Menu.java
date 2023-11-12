package christmas.model;

import java.util.List;
import java.util.ArrayList;

public class Menu {
    private List<Food> foods;

    public List<Food> getMenu() {
        return foods;
    }

    public Food getFood(String name) {
        List<Food> foods = initMenu();
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    public List<Food> initMenu() {
        List<Food> foods = new ArrayList<>();
        Food food = new FoodBuilder().category("애피타이저").name("양송이수프").price(6000).build();
        foods.add(food);
        food = new FoodBuilder().category("애피타이저").name("타파스").price(5500).build();
        foods.add(food);
        food = new FoodBuilder().category("애피타이저").name("시저샐러드").price(8000).build();
        foods.add(food);
        food = new FoodBuilder().category("메인").name("티본스테이크").price(6000).build();
        foods.add(food);
        food = new FoodBuilder().category("메인").name("바비큐립").price(54000).build();
        foods.add(food);
        food = new FoodBuilder().category("메인").name("해산물파스타").price(35000).build();
        foods.add(food);
        food = new FoodBuilder().category("메인").name("크리스마스파스타").price(25000).build();
        foods.add(food);
        food = new FoodBuilder().category("디저트").name("초코케이크").price(15000).build();
        foods.add(food);
        food = new FoodBuilder().category("디저트").name("아이스크림").price(5000).build();
        foods.add(food);
        food = new FoodBuilder().category("음료").name("제로콜라").price(3000).build();
        foods.add(food);
        food = new FoodBuilder().category("음료").name("레드와인").price(60000).build();
        foods.add(food);
        food = new FoodBuilder().category("음료").name("샴페인").price(25000).build();
        foods.add(food);

        return foods;
    }
}
