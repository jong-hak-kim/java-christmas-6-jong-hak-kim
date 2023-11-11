package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.parser.Parser;
import christmas.validate.InputValidate;

public class InputView {

    public int readDate() {
        InputValidate inputValidate = new InputValidate();
        Parser parser = new Parser();
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();

        inputValidate.validateNull(input);
        inputValidate.validateNumber(input);

        int numberInput = parser.numberParser(input);
        inputValidate.validateRange(numberInput);
        return numberInput;
    }

}