package baseball.vo;

import baseball.consts.ExceptionSentence;
import baseball.consts.ValueConstants;
import baseball.exception.ExceptionCaller;
import java.util.HashSet;
import java.util.List;

public class Numbers {
    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicated(numbers);
        numbers.forEach(this::validateRange);
    }

    private void validateDuplicated(List<Integer> numbers) {
        int trimmedSize = new HashSet<>(numbers).size();
        if (trimmedSize != ValueConstants.NUMBER_CIPHERS.getValue()) {
            throw ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.DUPLICATED.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < ValueConstants.START_INCLUSIVE.getValue()
                || number > ValueConstants.END_INCLUSIVE.getValue()) {
            throw ExceptionCaller.throwIllegalArgumentException(ExceptionSentence.NOT_IN_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
