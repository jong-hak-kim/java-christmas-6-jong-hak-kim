package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.ConstantMessage;
import christmas.parser.Parser;
import christmas.validate.InputValidate;
import static christmas.constant.ConstantMessage.*;

public class InputView {

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public int readDate() {
        InputValidate inputValidate = new InputValidate();
        Parser parser = new Parser();
        printConstantMessage(INPUT_DATE);
        String input = Console.readLine();

        inputValidate.validateNull(input);
        inputValidate.validateNumber(input);

        int numberInput = parser.numberParser(input);
        inputValidate.validateRange(numberInput);
        return numberInput;
    }

    public String readMenu() {
        InputValidate inputValidate = new InputValidate();
        printConstantMessage(INPUT_ORDER_MENU);
        String input = Console.readLine();

        inputValidate.validateNull(input);

        return input;
    }
}