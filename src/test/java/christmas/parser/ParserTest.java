package christmas.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void 입력_문자열_분리_테스트() {
        String input = "20,30,40,50,60";
        String[] result = { "20", "30", "40", "50", "60" };
        Parser parser = new Parser();
        Assertions.assertThat(parser.inputSplit(input)).isEqualTo(result);
    }

    @Test
    void 숫자_변환_테스트() {
        String input = "20";
        Parser parser = new Parser();
        Assertions.assertThat(parser.numberParser(input)).isEqualTo(20);
    }

    @Test
    void 주문_문자열_분리_테스트() {
        String input = "티본스테이크-1";
        String[] result = { "티본스테이크", "1" };
        Parser parser = new Parser();
        Assertions.assertThat(parser.orderSplit(input)).isEqualTo(result);
    }

    @Test
    void 숫자_형식_변환_테스트() {
        int input = 200000;
        Assertions.assertThat(Parser.parseNumberFormat(input)).isEqualTo("200,000");
    }
}
