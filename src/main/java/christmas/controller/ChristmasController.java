package christmas.controller;

import java.util.Map;

import christmas.view.InputView;

public class ChristmasController {

    private InputView inputView;

    public ChristmasController() {
        this.inputView = new InputView();
    }

    public void run() {
        int date = inputDate();
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

}
