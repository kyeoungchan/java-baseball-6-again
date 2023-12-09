package baseball.validator;

import baseball.consts.ExceptionSentence;
import baseball.consts.PatternRegex;
import baseball.consts.ValueConstants;
import baseball.exception.ExceptionCaller;
import baseball.vo.Retry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public List<Integer> convertNumbers(String inputData) {
        List<Integer> result = new ArrayList<>(ValueConstants.NUMBER_CIPHERS.getValue());
        validateNotEmpty(inputData);
        validateCiphers(inputData);
        validateNumbers(inputData);
        Arrays.stream(inputData.split(""))
                .map(Integer::parseInt)
                .forEach(result::add);

        return result;
    }

    private void validateNotEmpty(String inputData) {
        if (inputData == null || inputData.equals("")) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.EMPTY_INPUTTED.getMessage()
            );
        }
    }

    private void validateCiphers(String inputData) {
        int dataLength = inputData.length();
        validateTooLongCiphers(dataLength);
        validateTooShortCiphers(dataLength);
    }

    private void validateTooLongCiphers(int dataLength) {
        if (dataLength > ValueConstants.NUMBER_CIPHERS.getValue()) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.TOO_LONG_INPUTTED.getMessage()
            );
        }
    }

    private void validateTooShortCiphers(int dataLength) {
        if (dataLength < ValueConstants.NUMBER_CIPHERS.getValue()) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.TOO_SHORT_INPUTTED.getMessage()
            );
        }
    }

    private void validateNumbers(String inputData) {
        Pattern pattern = Pattern.compile(PatternRegex.NUMBERS.getRegex());
        Matcher matcher = pattern.matcher(inputData);
        if (!matcher.matches()) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.NOT_NUMBERS.getMessage()
            );
        }
    }


    public Retry convertRetry(String retryData) {
        int inputNumber = Integer.parseInt(retryData);
        return Arrays.stream(Retry.values())
                .filter(retry -> retry.kidsOf(inputNumber))
                .findAny()
                .orElseThrow(() -> ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.NOT_VALIDATED_RETRY_INPUT.getMessage()));
    }
}
