package christmas.controller;

import java.util.Map;

import christmas.model.Food;
import christmas.model.Order;
import christmas.view.InputView;

public class ChristmasController {

    private InputView inputView;
    private Order order;

    public ChristmasController() {
        this.inputView = new InputView();
        this.order = new Order();
    }

    public void run() {
        int date = inputDate();
        Map<Food, Integer> order = inputMenu();
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
}
