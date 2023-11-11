package christmas.validate;

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

}
