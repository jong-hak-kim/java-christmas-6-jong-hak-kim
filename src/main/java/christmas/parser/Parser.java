package christmas.parser;

public class Parser {
    public int numberParser(String input) {
        return Integer.parseInt(input);
    }

    public String[] inputSplit(String input) {
        return input.split(",");
    }

    public String[] orderSplit(String order) {
        return order.split("-");
    }
}
