package christmas.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;

public class InputViewTest extends NsTest {

    @Nested
    @DisplayName("날짜_입력_테스트")
    class CalendarInputTest {
        @Test
        void 날짜_문자_예외_테스트() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 날짜_범위_예외_테스트() {
            assertSimpleTest(() -> {
                runException("123");
                assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 날짜_빈값_예외_테스트() {
            assertSimpleTest(() -> {
                runException("\n");
                assertThat(output()).contains("[ERROR] 아무 것도 입력되지 않았습니다.");
            });
        }

    }

    @Nested
    @DisplayName("주문_입력_테스트")
    class OrderInputTest {
        @Test
        void 메뉴판_없는_메뉴_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n비빔밥-2");
                assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 한_개_미만_개수_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n티본스테이크-0");
                assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 메뉴_형식_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n티본스테이크-a");
                assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 중복_메뉴_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n티본스테이크-1,티본스테이크-2");
                assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            });
        }

        @Test
        void 음료_주문_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n제로콜라-1,레드와인-1");
                assertThat(output()).contains("[ERROR] 음료만 주문할 수 없습니다.");
            });
        }

        @Test
        void 메뉴_개수_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n티본스테이크-21,레드와인-1");
                assertThat(output()).contains("[ERROR] 20개 이상의 메뉴는 주문하실 수 없습니다.");
            });
        }

        @Test
        void 주문_빈_값_예외_테스트() {
            assertSimpleTest(() -> {
                runException("25\n\n");
                assertThat(output()).contains("[ERROR] 아무 것도 입력되지 않았습니다.");
            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
