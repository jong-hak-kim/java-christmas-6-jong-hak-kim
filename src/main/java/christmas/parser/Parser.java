package christmas.parser;

import java.text.DecimalFormat;

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

    public static String parseNumberFormat(int amount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(amount);
    }
}
