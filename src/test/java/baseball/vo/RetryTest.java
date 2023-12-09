package baseball.vo;

import baseball.consts.ExceptionSentence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RetryTest {

    @ParameterizedTest
    @DisplayName("입력받은 코드에 따라서 계속할지 게임을 멈출지 판단한다.")
    @CsvSource(value = {"1, true", "2, false"})
    void from(int code, boolean result) {
        assertThat(Retry.from(code).ifContinue()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("입력한 코드가 범위에 맞지 않은 숫자면 예외를 발생시킨다.")
    @CsvSource(value = {"3", "9"})
    void notValidatedRetry(int code) {
        assertThatThrownBy(() -> Retry.from(code))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Retry.from(code))
                .hasMessageContaining(ExceptionSentence.ERROR_CODE.getMessage());
        assertThatThrownBy(() -> Retry.from(code))
                .hasMessageContaining(ExceptionSentence.NOT_VALIDATED_RETRY_INPUT.getMessage());
    }
}