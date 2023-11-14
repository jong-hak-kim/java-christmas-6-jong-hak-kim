package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class EventTest {
    @Test
    void 크리스마스_디데이_할인_여부_테스트() {
        int date = 3;
        Event event = new Event();
        Assertions.assertThat(event.checkChristmasEvent(date)).isEqualTo(true);
    }

    @Test
    void 이벤트_자격_여부_테스트() {
        int sumPrice = 9000;
        Event event = new Event();
        Assertions.assertThat(event.checkEventQualify(sumPrice)).isEqualTo(false);
    }

    @Test
    void 증정_이벤트_여부_테스트() {
        int sumPrice = 130000;
        Event event = new Event();
        Assertions.assertThat(event.checkGiftEvent(sumPrice)).isEqualTo(true);
    }

    @Test
    void 특별_할인_여부_테스트() {
        int date = 3;
        Event event = new Event();
        Assertions.assertThat(event.checkSpecialEvent(date)).isEqualTo(true);
    }

    @Test
    void 평일_여부_테스트() {
        int dayOfWeekNumber = 5;
        Event event = new Event();
        Assertions.assertThat(event.checkWeekday(dayOfWeekNumber)).isEqualTo(false);
    }

    @Test
    void 크리스마스_디데이_할인_금액_테스트() {
        int date = 3;
        Event event = new Event();
        Assertions.assertThat(event.getChristmasEventBenefitAmount(date)).isEqualTo(1200);
    }

    @Test
    void 디저트_개수_테스트() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<Food, Integer> orderMenu = Order.takeOrder(input);
        Event event = new Event();
        Assertions.assertThat(event.getDessertCount(orderMenu)).isEqualTo(2);
    }

    @Test
    void 증정_이벤트_할인_금액_테스트() {
        Event event = new Event();
        Assertions.assertThat(event.getGiftEventBenefitAmount()).isEqualTo(25000);
    }

    @Test
    void 메인메뉴_개수_테스트() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<Food, Integer> orderMenu = Order.takeOrder(input);
        Event event = new Event();
        Assertions.assertThat(event.getMainMenuCount(orderMenu)).isEqualTo(2);
    }

    @Test
    void 특별_할인_금액_테스트() {
        Event event = new Event();
        Assertions.assertThat(event.getSpecialEventBenefitAmount()).isEqualTo(1000);
    }

    @Test
    void 할인_전_총금액_테스트() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<Food, Integer> orderMenu = Order.takeOrder(input);
        Event event = new Event();
        Assertions.assertThat(event.getSumPrice(orderMenu)).isEqualTo(142000);
    }

    @Test
    void 일자_번호_테스트() {
        int date = 3;
        Event event = new Event();
        Assertions.assertThat(event.getWeekNumber(date)).isEqualTo(7);
    }

    @Test
    void 평일_할인_금액_테스트() {
        int dessertCount = 2;
        Event event = new Event();
        Assertions.assertThat(event.getWeekendBenefitAmount(dessertCount)).isEqualTo(4046);
    }

    @Test
    void 주말_할인_금액_테스트() {
        int mainMenuCount = 2;
        Event event = new Event();
        Assertions.assertThat(event.getWeekendBenefitAmount(mainMenuCount)).isEqualTo(4046);
    }

    @Test
    void 이벤트_배지_테스트() {
        int totalBenefitAmount = 7000;
        Event event = new Event();
        Assertions.assertThat(event.getbadge(totalBenefitAmount)).isEqualTo(5000);
    }
}
