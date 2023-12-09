package baseball.vo;

import baseball.consts.ExceptionSentence;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class NumbersTest {
    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("Numbers 객체는 중복된 숫자가 있는지, 지정된 범위 외의 숫자가 있는지만 검증한다.")
    void notValidatedNumbers(List<Integer> inputNumbers, String errorMessage) {
        assertThatThrownBy(() -> new Numbers(inputNumbers))
                .hasMessageContaining(errorMessage);
        assertThatThrownBy(() -> new Numbers(inputNumbers))
                .hasMessageContaining(ExceptionSentence.ERROR_CODE.getMessage());
        assertThatThrownBy(() -> new Numbers(inputNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되지 않은 범위 내의 숫자를 입력하면 예외를 발생시키지 않는다.")
    void validateNumbers() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThatNoException().isThrownBy(() -> new Numbers(numbers));
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2), ExceptionSentence.DUPLICATED.getMessage()),
                Arguments.of(List.of(0, 1, 2), ExceptionSentence.NOT_IN_RANGE.getMessage()),
                Arguments.of(List.of(1, 2, 10), ExceptionSentence.NOT_IN_RANGE.getMessage())
        );
    }
}