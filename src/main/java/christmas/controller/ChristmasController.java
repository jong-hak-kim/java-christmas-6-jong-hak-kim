package christmas.controller;

import static christmas.exception.ErrorMessage.INCORRECT_DATE;
import static christmas.exception.ErrorMessage.INCORRECT_ORDER;

import java.util.Map;

import christmas.exception.ErrorMessage;
import christmas.model.Event;
import christmas.model.Food;
import christmas.model.Order;
import christmas.parser.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

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

    public static void printErrorMessage(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getErrorMessage());
    }

    public int inputDate() {
        while (true) {
            try {
                int input = inputView.readDate();
                return input;
            } catch (NumberFormatException numberFormatException) {
                printErrorMessage(INCORRECT_DATE);
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
                printErrorMessage(INCORRECT_ORDER);
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
        }
    }

    public void getEvent(int date, Map<Food, Integer> order) {

        OutputView.printEventPreview(date);
        int sumPrice = event.getSumPrice(order);
        
        OutputView.printMenu(order);

        String parseSumPrice = Parser.parseNumberFormat(sumPrice);
        OutputView.printBeforeBeneiftMoney(parseSumPrice);

        boolean hasGiftEvent = event.checkGiftEvent(sumPrice);
        OutputView.printGiftMenu(hasGiftEvent);

        int totalBenefitAmount = getBenefitList(date, sumPrice, order);

        String parseTotalBenefitAmount = Parser.parseNumberFormat(totalBenefitAmount);
        OutputView.printTotalBenefitAmount(parseTotalBenefitAmount);

        int sumDiscountPrice = getSumDiscountPrice(hasGiftEvent, sumPrice, totalBenefitAmount);
        String parseSumDiscountPrice = Parser.parseNumberFormat(sumDiscountPrice);
        OutputView.printAfterBenefitTotalMoney(parseSumDiscountPrice);

        int badge = event.getbadge(totalBenefitAmount);
        OutputView.printBadge(badge);
    }

    public int getBenefitList(int date, int sumPrice, Map<Food, Integer> order) {
        int dayOfWeekNumber = event.getWeekNumber(date);
        int totalBenefitAmount = 0;
        OutputView.printBenefitList();
        if (event.checkEventQualify(sumPrice)) {
            totalBenefitAmount += getChristmasEvent(date);
            totalBenefitAmount += getGiftEvent(sumPrice);
            totalBenefitAmount += getWeekdayEvent(dayOfWeekNumber, order);
            totalBenefitAmount += getWeekendEvent(dayOfWeekNumber, order);
            totalBenefitAmount += getSpecialEvent(date);
        }
        if (!event.checkEventQualify(sumPrice)) {
            OutputView.printNothing();
        }
        return totalBenefitAmount;
    }

    public int getChristmasEvent(int date) {
        int christmasEventBenefitAmount = 0;
        if (event.checkChristmasEvent(date)) {
            christmasEventBenefitAmount = event.getChristmasEventBenefitAmount(date);
            String parseChristmasEventBenefitAmount = Parser.parseNumberFormat(christmasEventBenefitAmount);
            OutputView.printChristmasDiscount(parseChristmasEventBenefitAmount);
        }
        return christmasEventBenefitAmount;
    }

    public int getGiftEvent(int sumPrice) {
        int giftEventBenefitAmount = 0;
        if (event.checkGiftEvent(sumPrice)) {
            giftEventBenefitAmount = event.getGiftEventBenefitAmount();
            String parseGiftEventBenefitAmount = Parser.parseNumberFormat(giftEventBenefitAmount);
            OutputView.printGiftDiscount(parseGiftEventBenefitAmount);
        }
        return giftEventBenefitAmount;
    }

    public int getWeekdayEvent(int dayOfWeekNumber, Map<Food, Integer> order) {
        int weekdayBenefitAmount = 0;
        if (event.checkWeekday(dayOfWeekNumber)) {
            int getDessertCount = event.getDessertCount(order);
            weekdayBenefitAmount = event.getWeekdayBenefitAmount(getDessertCount);
            String ParseWeekdayBenefitAmount = Parser.parseNumberFormat(weekdayBenefitAmount);
            OutputView.printWeekdayDiscount(ParseWeekdayBenefitAmount);
        }
        return weekdayBenefitAmount;
    }

    public int getWeekendEvent(int dayOfWeekNumber, Map<Food, Integer> order) {
        int weekendBenefitAmount = 0;
        if (!event.checkWeekday(dayOfWeekNumber)) {
            int getMainMenuCount = event.getMainMenuCount(order);
            weekendBenefitAmount = event.getWeekendBenefitAmount(getMainMenuCount);
            String parseWeekendBenefitAmount = Parser.parseNumberFormat(weekendBenefitAmount);
            OutputView.printWeekendDiscount(parseWeekendBenefitAmount);
        }
        return weekendBenefitAmount;
    }

    public int getSpecialEvent(int date) {
        int specialEventBenefitAmount = 0;
        if (event.checkSpecialEvent(date)) {
            specialEventBenefitAmount = event.getSpecialEventBenefitAmount();
            String parseSpecialEventBenefitAmount = Parser.parseNumberFormat(specialEventBenefitAmount);
            OutputView.printSpecialDiscount(parseSpecialEventBenefitAmount);
        }
        return specialEventBenefitAmount;
    }

    public int getSumDiscountPrice(boolean hasGiftEvent, int sumPrice, int totalBenefitAmount) {
        int sumDiscountPrice = 0;
        if (hasGiftEvent) {
            sumDiscountPrice = sumPrice - totalBenefitAmount - event.getGiftEventBenefitAmount();
        }
        if (!hasGiftEvent) {
            sumDiscountPrice = sumPrice - totalBenefitAmount;
        }
        return sumDiscountPrice;
    }
}
