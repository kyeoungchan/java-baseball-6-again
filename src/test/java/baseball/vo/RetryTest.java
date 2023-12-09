package baseball.vo;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RetryTest {

    @ParameterizedTest
    @DisplayName("입력받은 코드에 따라서 계속할지 게임을 멈출지 판단한다.")
    @CsvSource(value = {"1, true", "2, false"})
    void kidsOf(int code, boolean result) {
        Arrays.stream(Retry.values())
                .filter(r -> r.kidsOf(code))
                .forEach(r -> assertThat(r.ifContinue()).isEqualTo(result));
    }
}