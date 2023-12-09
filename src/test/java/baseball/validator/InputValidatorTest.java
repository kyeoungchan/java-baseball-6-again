package baseball.validator;

import baseball.consts.ExceptionSentence;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @MethodSource("generateNumbers")
    @DisplayName("세자리 숫자를 입력하지 않으면 IllegalArgumentException을 던진다.")
    void convertUnvalidatedNumbers(String inputData, String exceptionMessage) {
        assertThatThrownBy(() -> inputValidator.convertNumbers(inputData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.convertNumbers(inputData)).hasMessageContaining(ExceptionSentence.ERROR_CODE.getMessage());
        assertThatThrownBy(() -> inputValidator.convertNumbers(inputData)).hasMessageContaining(exceptionMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {"123", "456", "971", "999"})
    @DisplayName("세자리 숫자를 입력하면 예외가 발생하지 않는다. InputValidator 는 중복 숫자 검증 X")
    void convertValidatedNumbers(String inputData) {
        assertThatNoException().isThrownBy(() -> inputValidator.convertNumbers(inputData));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2"})
    @DisplayName("1이나 2를 입력하면 예외가 발생하지 않는다.")
    void convertValidatedRetry(String inputData) {
        assertThatNoException().isThrownBy(() -> inputValidator.convertRetry(inputData));
    }

    @ParameterizedTest
    @MethodSource("generateRetry")
    @DisplayName("한자리 숫자를 입력하지 않으면 IllegalArgumentException을 던진다.")
    void convertUnvalidatedRetry(String inputData, String exceptionMessage) {
        assertThatThrownBy(() -> inputValidator.convertRetry(inputData))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.convertRetry(inputData)).hasMessageContaining(ExceptionSentence.ERROR_CODE.getMessage());
        assertThatThrownBy(() -> inputValidator.convertRetry(inputData)).hasMessageContaining(exceptionMessage);
    }

    private static Stream<Arguments> generateNumbers() {
        return Stream.of(
                Arguments.of(null, ExceptionSentence.EMPTY_INPUTTED.getMessage()),
                Arguments.of("", ExceptionSentence.EMPTY_INPUTTED.getMessage()),
                Arguments.of("1234", ExceptionSentence.TOO_LONG_INPUTTED.getMessage()),
                Arguments.of("12", ExceptionSentence.TOO_SHORT_INPUTTED.getMessage()),
                Arguments.of("abc", ExceptionSentence.NOT_NUMBERS.getMessage())
        );
    }

    private static Stream<Arguments> generateRetry() {
        return Stream.of(
                Arguments.of(null, ExceptionSentence.EMPTY_INPUTTED.getMessage()),
                Arguments.of("", ExceptionSentence.EMPTY_INPUTTED.getMessage()),
                Arguments.of("14", ExceptionSentence.TOO_LONG_INPUTTED.getMessage()),
                Arguments.of("a", ExceptionSentence.NOT_NUMBERS.getMessage()),
                Arguments.of("3", ExceptionSentence.NOT_VALIDATED_RETRY_INPUT.getMessage())
        );
    }
}