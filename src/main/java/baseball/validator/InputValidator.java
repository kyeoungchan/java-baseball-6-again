package baseball.validator;

import baseball.consts.ExceptionSentence;
import baseball.exception.ExceptionCaller;
import baseball.vo.Retry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public List<Integer> convertNumbers(String inputData) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public Retry convertRetry(String retryData) {
        int inputNumber = Integer.parseInt(retryData);
        return Arrays.stream(Retry.values())
                .filter(retry -> retry.kidsOf(inputNumber))
                .findAny()
                .orElseThrow(()-> ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.NOT_VALIDATED_RETRY_INPUT.getMessage()));
    }
}
