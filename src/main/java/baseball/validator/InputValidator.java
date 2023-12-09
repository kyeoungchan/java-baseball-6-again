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
        List<Integer> result = new ArrayList<>(ValueConstants.NUMBERS_CIPHERS.getValue());
        validateNumbers(inputData);
        Arrays.stream(inputData.split(""))
                .map(Integer::parseInt)
                .forEach(result::add);

        return result;
    }

    private void validateNumbers(String inputData) {
        validateNotEmpty(inputData);
        validateRegex(inputData, PatternRegex.NUMBERS.getRegex());
        validateCiphers(inputData, ValueConstants.NUMBERS_CIPHERS.getValue());
    }

    private void validateNotEmpty(String inputData) {
        if (inputData == null || inputData.equals("")) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.EMPTY_INPUTTED.getMessage()
            );
        }
    }

    private void validateCiphers(String inputData, int ciphers) {
        int dataLength = inputData.length();
        validateTooLongCiphers(dataLength, ciphers);
        validateTooShortCiphers(dataLength, ciphers);
    }

    private void validateTooLongCiphers(int dataLength, int ciphers) {
        if (dataLength > ciphers) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.TOO_LONG_INPUTTED.getMessage()
            );
        }
    }

    private void validateTooShortCiphers(int dataLength, int ciphers) {
        if (dataLength < ciphers) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.TOO_SHORT_INPUTTED.getMessage()
            );
        }
    }

    private void validateRegex(String inputData, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputData);
        if (!matcher.matches()) {
            throw ExceptionCaller.throwIllegalArgumentException(
                    ExceptionSentence.NOT_NUMBERS.getMessage()
            );
        }
    }

    public Retry convertRetry(String retryData) {
        validateRetry(retryData);
        int inputNumber = Integer.parseInt(retryData);
        return Retry.from(inputNumber);
    }

    private void validateRetry(String retryData) {
        validateNotEmpty(retryData);
        validateCiphers(retryData, ValueConstants.RETRY_CIPHER.getValue());
        validateRegex(retryData, PatternRegex.SINGLE_NUMBER.getRegex());
    }
}
