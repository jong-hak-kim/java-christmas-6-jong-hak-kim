package christmas.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;

public class InputViewTest extends NsTest {
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

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
